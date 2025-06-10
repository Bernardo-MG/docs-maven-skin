// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

def body = parsed.body()

// Tables
def table = body.select('table').first()
assert table.hasClass('table')
assert table.hasClass('table-striped')
assert table.hasClass('table-bordered')

assert body.select('tr').size() == 3
