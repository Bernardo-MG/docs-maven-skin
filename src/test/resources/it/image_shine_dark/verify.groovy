// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// Images
def fig = parsed.body().select('figure').first()
assert fig.hasClass('bg-dark')
