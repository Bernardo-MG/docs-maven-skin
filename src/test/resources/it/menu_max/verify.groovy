// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies the menus exist
assert body.select( '#navbar-main-menu .dropdown-toggle' ).size() == 12

// Verifies the menu links exist
def dropdowns = body.select( '#navbar-main-menu .dropdown' )
assert dropdowns.get(0).select( '.dropdown-item' ).size() == 10
