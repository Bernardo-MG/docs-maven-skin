// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def head = Jsoup.parse(html).head()

// Searches for the additional content
assert head.select('meta[name="test"]').attr('content').equals('value')
