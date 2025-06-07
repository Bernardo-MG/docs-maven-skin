// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// Select the first figure element
def fig = parsed.body().select('figure').first()

// Assert that the figure has the 'bg-dark' class
assert fig != null
assert fig.hasClass('bg-dark')