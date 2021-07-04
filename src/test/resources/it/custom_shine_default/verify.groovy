// This script verifies the Bootswatch style can be changed

import org.jsoup.Jsoup

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// The dark style is applied
def nav = body.select( '#navbar-main-menu' )
assert nav.hasClass( 'navbar-light' )
assert nav.hasClass( 'bg-light' )
