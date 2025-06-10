// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies that the footer menus are not generated
assert body.select('#navbar-footer').isEmpty()

// Verifies that the icon menus are not generated
assert body.select('#navbar-main-menu a').isEmpty()

// Verifies that the right navigation bar was not generated
assert body.select('#navbar-main-menu .dropdown-toggle').isEmpty()