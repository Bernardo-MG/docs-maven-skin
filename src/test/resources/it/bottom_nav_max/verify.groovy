// This script verifies that a site contains the bottom navigation.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// The footer columns exist
assert body.select('footer dl dt').size() == 12

// The footer columns data exists
def rows = body.select('footer dl')

// First column
assert rows.first().select('dd').size() == 10
