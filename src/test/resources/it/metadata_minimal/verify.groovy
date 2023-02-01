// This script verifies that a site with only metadata set up contains the correct metadata.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def head = Jsoup.parse(html).head()

// Verifies the basic metadata is generated
def metaContentType = head.select( 'meta[charset="utf-8"]' )
def metaViewport = head.select( 'meta[name="viewport"]' )

assert metaContentType != null
assert metaViewport.attr( 'content' ).equals( 'width=device-width, initial-scale=1, shrink-to-fit=no' )

// Verifies the general information metadata is generated
def metaDesc = head.select( 'meta[name="description"]' )
def metaKeywords = head.select( 'meta[name="keywords"]' )
def metaAuthor = head.select( 'meta[name="author"]' )

assert metaDesc.isEmpty()
assert metaKeywords.isEmpty()
assert metaAuthor.isEmpty()

// Verifies the Facebook Open Graph metadata is generated
def metaOgType = head.select( 'meta[property="og:type"]' )
def metaOgUrl = head.select( 'meta[property="og:url"]' )
def metaOgSite = head.select( 'meta[property="og:site_name"]' )
def metaOgTitle = head.select( 'meta[property="og:title"]' )
def metaOgDesc = head.select( 'meta[property="og:description"]' )

assert metaOgType.attr( 'content' ).equals( 'website' )
assert metaOgUrl.isEmpty()
assert metaOgSite.attr( 'content' ).equals( 'metadata-minimal-site – Metadata minimal page' )
assert metaOgTitle.attr( 'content' ).equals( 'metadata-minimal-site – Metadata minimal page' )
assert metaOgDesc.isEmpty()

// Verifies the Twitter metadata is generated
def metaTwCard = head.select( 'meta[name="twitter:card"]' )
def metaTwSite = head.select( 'meta[name="twitter:creator"]' )
def metaTwTitle = head.select( 'meta[name="twitter:title"]' )
def metaTwDesc = head.select( 'meta[name="twitter:description"]' )

assert metaTwCard.attr( 'content' ).equals( 'summary' )
assert metaTwSite.isEmpty()
assert metaTwTitle.attr( 'content' ).equals( 'metadata-minimal-site – Metadata minimal page' )
assert metaTwDesc.isEmpty()
