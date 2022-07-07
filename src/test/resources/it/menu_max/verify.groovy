// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies the menus exist
def toggles = body.select( '#navbar-main-menu .dropdown-toggle' )
assert toggles.size() == 12

// Verifies the menu links exist
def dropdowns = body.select( '#navbar-main-menu .dropdown' )
def items = dropdowns.get(0).select( '.dropdown-item' )
assert items.size() == 10
