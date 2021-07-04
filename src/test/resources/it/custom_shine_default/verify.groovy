// This script verifies the Bootswatch style can be changed

import org.jsoup.Jsoup

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// The default style is applied to the nav bar
def nav = body.select( '#navbar-main' )
assert nav.hasClass( 'navbar-light' )
assert nav.hasClass( 'bg-light' )

// The default style is applied to the footer
def footer = body.select( 'footer' )
assert footer.hasClass( 'bg-light' )

def footernav = body.select( '#footer-nav' )
assert footernav.hasClass( 'bg-light' )

def footerinfo = body.select( '#footer-info' )
assert footerinfo.hasClass( 'bg-light' )
