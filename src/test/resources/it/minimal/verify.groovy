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

// Verifies the skin info is included

// Footer link
def div = body.select( 'footer.footer div.row div' ).last()
assert div.html().contains( 'Rendered using' )

// Comments before the head
assert html.contains( 'Rendered using Docs Maven Skin' )
assert html.contains( 'Generated by Apache Maven Doxia' )

// Verifies the footer menus were not generated
def titles = body.select( 'dt' )
assert titles.size() == 0

// Verifies that the footer menus are not generated
def navbarFooter = body.select( '#navbar-footer' )
assert navbarFooter.size() == 0

def dlNav = body.select( '.dl-nav' )
assert dlNav.size() == 0

// Verifies that only the minimal metadata is included
def meta = head.select( 'meta' )
assert meta.size() == 6

assert meta.get(0).attr( 'http-equiv' ).equals( 'Content-Type' )
assert meta.get(1).attr( 'name' ).equals( 'viewport' )
assert meta.get(2).attr( 'http-equiv' ).equals( 'X-UA-Compatible' )

// Facebook Open Graph metadata
assert meta.get(3).attr( 'property' ).equals( 'og:type' )
assert meta.get(3).attr( 'content' ).equals( 'website' )

assert meta.get(4).attr( 'property' ).equals( 'og:site' )
assert meta.get(4).attr( 'content' ).contains( 'minimal-site' )
assert meta.get(4).attr( 'content' ).contains( 'Minimal page' )

assert meta.get(5).attr( 'property' ).equals( 'og:title' )
assert meta.get(5).attr( 'content' ).contains( 'minimal-site' )
assert meta.get(5).attr( 'content' ).contains( 'Minimal page' )

// Verifies that the main menus are not generated
def dropdown = body.select( 'li.dropdown' )
assert dropdown.size() == 0
