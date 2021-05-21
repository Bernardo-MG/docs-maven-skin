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
def toggles = body.select( '#navbar-main-menu .dropdown-toggle' )
assert toggles.size() == 2

def toggle = toggles.get(0)
assert toggle.tag().normalName().equals('a')
assert toggle.id().equals('Documentation_menu')
assert toggle.attr( 'href' ).equals('#')
assert toggle.attr( 'data-bs-toggle' ).equals('dropdown')
assert toggle.attr( 'role' ).equals('button')
assert toggle.attr( 'aria-haspopup' ).equals('true')
assert toggle.attr( 'aria-expanded' ).equals('false')
assert toggle.html().equals('Documentation')
assert toggle.hasClass( 'nav-link' )
assert toggle.hasClass( 'dropdown-toggle' )

toggle = toggles.get(1)
assert toggle.tag().normalName().equals('a')
assert toggle.id().equals('Info_and_reports_menu')
assert toggle.attr( 'href' ).equals('#')
assert toggle.attr( 'data-bs-toggle' ).equals('dropdown')
assert toggle.attr( 'role' ).equals('button')
assert toggle.attr( 'aria-haspopup' ).equals('true')
assert toggle.attr( 'aria-expanded' ).equals('false')
assert toggle.html().equals('Info and reports')
assert toggle.hasClass( 'nav-link' )
assert toggle.hasClass( 'dropdown-toggle' )

// Verifies the menu links exist
def dropdowns = body.select( '#navbar-main-menu .dropdown' )
def items = dropdowns.get(0).select( '.dropdown-item' )

def item = items.get(0)
assert item.attr( 'href' ).equals('./acquire.html')
assert item.attr( 'title' ).equals('Acquire')
assert item.html().equals('Acquire')
assert item.hasClass( 'dropdown-item' )

item = items.get(1)
assert item.attr( 'href' ).equals('./usage.html')
assert item.attr( 'title' ).equals('Usage')
assert item.html().equals('Usage')
assert item.hasClass( 'dropdown-item' )

items = dropdowns.get(1).select( '.dropdown-item' )

item = items.get(0)
assert item.attr( 'href' ).equals('./info.html')
assert item.attr( 'title' ).equals('Info')
assert item.html().equals('Info')
assert item.hasClass( 'dropdown-item' )
