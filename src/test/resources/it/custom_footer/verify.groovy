// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies that the footer custom content was generated
assert body.select( '#footer-custom-content' ).html().equals( 'Custom footer content' )
