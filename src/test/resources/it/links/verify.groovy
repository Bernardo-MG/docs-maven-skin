// This script verifies that a minimal site contains only the barebones of a site.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup

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

// Verifies the menus exist
def dropdowns = body.select( '#navbar-main-menu .dropdown-toggle' )
assert dropdowns.size() == 1

def dropdown = dropdowns.first()
assert dropdown.tag().normalName().equals('a')
assert dropdown.id().equals('links_menu')
assert dropdown.attr( 'href' ).equals('#')
assert dropdown.attr( 'data-bs-toggle' ).equals('dropdown')
assert dropdown.attr( 'role' ).equals('button')
assert dropdown.attr( 'aria-haspopup' ).equals('true')
assert dropdown.attr( 'aria-expanded' ).equals('false')
assert dropdown.html().equals('Links')
assert dropdown.hasClass( 'nav-link' )
assert dropdown.hasClass( 'dropdown-toggle' )

// Verifies the menu links exist
def items = body.select( '#navbar-main-menu .dropdown-item' )

def item = items.get(0)
assert item.attr( 'href' ).equals('http://www.apache.org')
assert item.attr( 'title' ).equals('Apache')
assert item.html().equals('Apache')
assert item.hasClass( 'dropdown-item' )

item = items.get(1)
assert item.attr( 'href' ).equals('https://maven.apache.org')
assert item.attr( 'title' ).equals('Maven')
assert item.html().equals('Maven')
assert item.hasClass( 'dropdown-item' )
