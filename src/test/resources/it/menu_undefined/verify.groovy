// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

def body = parsed.body()

// Verifies that the footer menus are not generated
def navbarFooter = body.select( '#navbar-footer' )
assert navbarFooter.isEmpty()

// Verifies that the icon menus are not generated
def iconMenu = body.select( '#navbar-main-menu a' )
assert iconMenu.isEmpty()

// Verifies that the right navigation bar was not generated
def rightNavBar = body.select( '#navbar-main-menu .dropdown-toggle' )
assert rightNavBar.isEmpty()
