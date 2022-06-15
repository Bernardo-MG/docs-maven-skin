// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def body = parsed.body()
def head = parsed.head()

// The heading is set
def heading = body.select( '#main-section header' )
assert heading.html().equals( '<h1 id="With-description">With description</h1>' )

// The title is included in the HTML head
def title = head.select( 'title' )
assert title.html().equals( 'Project with description – With description' )

// The title is included in the header
def titleHeader = body.select( '#navbar-main a.navbar-brand' ).first()
assert titleHeader.tag().normalName().equals('a')
assert titleHeader.attr( 'href' ).equals('./index.html')
assert titleHeader.hasClass( 'navbar-brand' )
assert titleHeader.html().equals( 'Project with description' )

// The title is included in the metadata
def metaOgSite = head.select( 'meta[property="og:site_name"]' )
def metaOgTitle = head.select( 'meta[property="og:title"]' )

assert metaOgSite.attr( 'content' ).equals( 'Project with description – With description' )
assert metaOgTitle.attr( 'content' ).equals( 'Project with description – With description' )

// The Twitter metadata is generated
def metaTwTitle = head.select( 'meta[name="twitter:title"]' )

assert metaTwTitle.attr( 'content' ).equals( 'Project with description – With description' )
