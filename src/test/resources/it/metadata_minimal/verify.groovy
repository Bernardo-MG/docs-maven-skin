// This script verifies that a site with only metadata set up contains the correct metadata.

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
def head = Jsoup.parse(html).head()

// Verifies the basic metadata is generated
def metaContentType = head.select( 'meta[http-equiv="Content-Type"]' )
def metaViewport = head.select( 'meta[name="viewport"]' )
def metaCompatible = head.select( 'meta[http-equiv="X-UA-Compatible"]' )

assert metaContentType.attr( 'content' ).equals( 'text/html; charset=UTF-8' )
assert metaViewport.attr( 'content' ).equals( 'width=device-width, initial-scale=1.0' )
assert metaCompatible.attr( 'content' ).equals( 'IE=edge' )

// Verifies the general information metadata is generated
def metaDesc = head.select( 'meta[name="description"]' )
def metaKeywords = head.select( 'meta[name="keywords"]' )
def metaAuthor = head.select( 'meta[name="author"]' )

assert metaDesc.isEmpty()
assert metaKeywords.isEmpty()
assert metaAuthor.isEmpty()

// Verifies the Facebook Open Graph metadata is generated
def metaOgType = head.select( 'meta[property="og:type"]' )
def metaOgUrl = head.select( 'meta[property="og:url"]' )
def metaOgSite = head.select( 'meta[property="og:site"]' )
def metaOgTitle = head.select( 'meta[property="og:title"]' )
def metaOgDesc = head.select( 'meta[property="og:description"]' )

assert metaOgType.attr( 'content' ).equals( 'website' )
assert metaOgUrl.isEmpty()
assert metaOgSite.attr( 'content' ).equals( 'metadata-site – Metadata page' )
assert metaOgTitle.attr( 'content' ).equals( 'metadata-site – Metadata page' )
assert metaOgDesc.isEmpty()

// Verifies the Twitter metadata is generated
def metaTwCard = head.select( 'meta[name="twitter:card"]' )
def metaTwSite = head.select( 'meta[name="twitter:site"]' )
def metaTwTitle = head.select( 'meta[name="twitter:title"]' )
def metaTwDesc = head.select( 'meta[name="twitter:description"]' )

assert metaTwCard.attr( 'content' ).equals( 'summary' )
assert metaTwSite.attr( 'content' ).equals( '@bmg' )
assert metaTwTitle.attr( 'content' ).equals( 'metadata-site – Metadata page' )
assert metaTwDesc.isEmpty()
