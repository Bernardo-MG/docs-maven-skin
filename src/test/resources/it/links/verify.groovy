// This script verifies that the custom links are generated correctly.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies the menus exist
def dropdowns = body.select( '#navbar-main-menu .dropdown-toggle' )
assert dropdowns.size() == 1

// Verifies the dropdown toggle structure
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

// Verifies the first link
def item = items.get(0)
assert item.attr( 'href' ).equals('http://www.apache.org')
assert item.attr( 'title' ).equals('Apache')
assert item.attr( 'aria-label' ).equals('Apache')
assert item.html().equals('Apache')
assert item.hasClass( 'dropdown-item' )

// Verifies the second link
item = items.get(1)
assert item.attr( 'href' ).equals('https://maven.apache.org')
assert item.attr( 'title' ).equals('Maven')
assert item.attr( 'aria-label' ).equals('Maven')
assert item.html().equals('Maven')
assert item.hasClass( 'dropdown-item' )
