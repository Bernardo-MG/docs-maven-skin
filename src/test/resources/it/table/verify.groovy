// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def body = parsed.body()
def head = parsed.head()

// Tables
def table = body.select( 'table' ).first()
assert table.hasClass( 'table' )
assert table.hasClass( 'table-striped' )
assert table.hasClass( 'table-bordered' )

def rows = body.select( 'tr' )
assert rows.size() == 3
