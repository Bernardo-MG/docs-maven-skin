// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def head = Jsoup.parse(html).head()

// Searches for the additional content
def metaTest = head.select( 'meta[name="test"]' )

assert metaTest.attr( 'content' ).equals( 'value' )
