// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

def head = parsed.head()

// Verifies the title is included in the HTML head
def title = head.select( 'title' )
assert title.html().equals( 'Title override – Overriden' )

// Verifies the title is included in the header
def titleHeader = parsed.body().select( '#navbar-main a.navbar-brand' )
assert titleHeader.html().equals( 'title_override' )

// Verifies the title is included in the metadata
def metaOgSite = head.select( 'meta[property="og:site_name"]' )
def metaOgTitle = head.select( 'meta[property="og:title"]' )

assert metaOgSite.attr( 'content' ).equals( 'Title override – Overriden' )
assert metaOgTitle.attr( 'content' ).equals( 'Title override – Overriden' )

// Verifies the Twitter metadata is generated
def metaTwTitle = head.select( 'meta[name="twitter:title"]' )

assert metaTwTitle.attr( 'content' ).equals( 'Title override – Overriden' )
