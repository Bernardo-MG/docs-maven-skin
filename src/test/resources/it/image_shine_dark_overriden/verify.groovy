// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def body = parsed.body()

// Images
def fig = body.select( 'figure' ).first()
assert fig.hasClass( 'bg-white' )