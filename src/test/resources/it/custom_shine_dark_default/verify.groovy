// This script verifies the Bootswatch style can be changed

import org.jsoup.Jsoup

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// The dark style is applied to the nav bar
def nav = body.select( '#navbar-main' )
assert nav.hasClass( 'bg-primary' )
assert nav.hasAttr( 'data-bs-theme' )
assert nav.attr( 'data-bs-theme' ).equals( 'primary' )

// The default style is applied to the footer
def footer = body.select( 'footer' )
assert footer.hasClass( 'bg-primary' )
assert footer.hasAttr( 'data-bs-theme' )
assert footer.attr( 'data-bs-theme' ).equals( 'primary' )

def footerinfo = body.select( '#footer-info' )
assert footerinfo.hasClass( 'bg-primary' )
