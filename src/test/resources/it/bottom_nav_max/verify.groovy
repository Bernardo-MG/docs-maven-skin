// This script verifies that a site contains the bottom navigation.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// The footer columns exist
def titles = body.select( 'footer dl dt' )
assert titles.size() == 12

// The footer columns data exists
def rows = body.select( 'footer dl dd' )

rows = body.select( 'footer dl' )

// First column
def row = rows.first().select( 'dd' )
assert row.size() == 10
