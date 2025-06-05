// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies the project version is included
assert body.select( '#navbar-version' ).html() =~ /1\.0\.0/

// Verifies the project date is included
assert body.select( '#navbar-date' ).isEmpty()
