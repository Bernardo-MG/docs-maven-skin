// This script verifies that the Google options are applied correctly.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies Google Analytics was set up
assert html.contains( 'Google Analytics' )

def googleAnalyticsScript = body.select( 'script[src="https://www.googletagmanager.com/gtag/js?id=abcd"]' )
assert googleAnalyticsScript != null
