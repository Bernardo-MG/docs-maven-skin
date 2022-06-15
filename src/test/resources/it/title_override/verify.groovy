// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def body = parsed.body()
def head = parsed.head()

// Verifies the title is included in the HTML head
def title = head.select( 'title' )
assert title.html().equals( 'Overriden – Title override' )

// Verifies the title is included in the header
def titleHeader = body.select( '#navbar-main a.navbar-brand' )
assert titleHeader.html().equals( 'title_override' )

// Verifies the title is included in the metadata
def metaOgSite = head.select( 'meta[property="og:site_name"]' )
def metaOgTitle = head.select( 'meta[property="og:title"]' )

assert metaOgSite.attr( 'content' ).equals( 'Overriden – Title override' )
assert metaOgTitle.attr( 'content' ).equals( 'Overriden – Title override' )

// Verifies the Twitter metadata is generated
def metaTwTitle = head.select( 'meta[name="twitter:title"]' )

assert metaTwTitle.attr( 'content' ).equals( 'Overriden – Title override' )
