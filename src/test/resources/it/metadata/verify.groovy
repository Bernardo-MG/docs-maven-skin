// This script verifies that a site with only metadata set up contains the correct metadata.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def head = Jsoup.parse(html).head()

// Verifies the basic metadata is generated
assert head.select( 'meta[charset="utf-8"]' ) != null

def metaViewport = head.select( 'meta[name="viewport"]' )
assert metaViewport.attr( 'content' ).equals( 'width=device-width, initial-scale=1, shrink-to-fit=no' )

// Verifies the general information metadata is generated
def metaDesc = head.select( 'meta[name="description"]' )
def metaKeywords = head.select( 'meta[name="keywords"]' )
def metaAuthor = head.select( 'meta[name="author"]' )

assert metaDesc.attr( 'content' ).equals( 'Check the documentation for the example' )
assert metaKeywords.attr( 'content' ).equals( 'Maven, Java, library' )
assert metaAuthor.attr( 'content' ).equals( 'Bernardo Martínez Garrido' )

// Verifies the Facebook Open Graph metadata is generated
def metaOgType = head.select( 'meta[property="og:type"]' )
def metaOgUrl = head.select( 'meta[property="og:url"]' )
def metaOgSite = head.select( 'meta[property="og:site_name"]' )
def metaOgTitle = head.select( 'meta[property="og:title"]' )
def metaOgDesc = head.select( 'meta[property="og:description"]' )

assert metaOgType.attr( 'content' ).equals( 'website' )
assert metaOgUrl.attr( 'content' ).equals( 'http://canonicallink' )
assert metaOgSite.attr( 'content' ).equals( 'Metadata page – metadata-site' )
assert metaOgTitle.attr( 'content' ).equals( 'Metadata page – metadata-site' )
assert metaOgDesc.attr( 'content' ).equals( 'Check the documentation for the example' )

// Verifies the Twitter metadata is generated
def metaTwCard = head.select( 'meta[name="twitter:card"]' )
def metaTwSite = head.select( 'meta[name="twitter:creator"]' )
def metaTwTitle = head.select( 'meta[name="twitter:title"]' )
def metaTwDesc = head.select( 'meta[name="twitter:description"]' )

assert metaTwCard.attr( 'content' ).equals( 'summary' )
assert metaTwSite.attr( 'content' ).equals( '@bmg' )
assert metaTwTitle.attr( 'content' ).equals( 'Metadata page – metadata-site' )
assert metaTwDesc.attr( 'content' ).equals( 'Check the documentation for the example' )
