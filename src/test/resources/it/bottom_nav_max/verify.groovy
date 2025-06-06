// This script verifies that a site contains the bottom navigation.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// The footer columns exist
def titles = body.select('footer dl dt')
assert titles.size() == 12

// The footer columns data exists
def rows = body.select('footer dl')

// First column
def row = rows.first().select('dd')
assert row.size() == 10
