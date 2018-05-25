// This script verifies that a minimal site contains only the barebones of a site.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup

// Verifies that all the files were created
[
    'target/site/index.html'
].each {
    def file = new File(basedir, it)
    if (!file.exists()) {
        throw new IllegalStateException(
            "file ${file} doesn't exist"
        )
    }
}

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Validates HTML 5
def htmlResponse = new ValidatorBuilder().html().validate(html)

MatcherAssert.assertThat(
    'There are errors',
    htmlResponse.errors(),
    Matchers.describedAs(htmlResponse.toString(), Matchers.hasSize(0))
)
MatcherAssert.assertThat(
    'There are warnings',
    htmlResponse.warnings(),
    Matchers.describedAs(htmlResponse.toString(), Matchers.hasSize(0))
)

// Parses HTML
def body = Jsoup.parse(html).body()
def head = Jsoup.parse(html).head()

// Verifies the title is included in the HTML head
def title = head.select( 'title' )
// assert title.html().equals( 'Overriden' )

// Verifies the title is included in the header
def titleHeader = body.select( '#navbar-main a.navbar-brand' )
// assert titleHeader.html().equals( 'Overriden' )

// Verifies the title is included in the metadata
def metaOgSite = head.select( 'meta[property="og:site_name"]' )
def metaOgTitle = head.select( 'meta[property="og:title"]' )
assert metaOgSite.attr( 'content' ).equals( 'Overriden – Title override' )
assert metaOgTitle.attr( 'content' ).equals( 'Overriden – Title override' )
