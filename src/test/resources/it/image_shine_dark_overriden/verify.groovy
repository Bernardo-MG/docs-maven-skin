// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// Figure color
def figures = parsed.body().select('figure')
assert !figures.isEmpty()
assert figures.first().hasClass('bg-white')