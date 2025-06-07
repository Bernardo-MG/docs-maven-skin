// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

def head = parsed.head()

// Verifies the title is included in the HTML head
assert head.select('title').html() == 'Title override – Overriden'

// Verifies the title is included in the header
assert parsed.body().select('#navbar-main a.navbar-brand').html() == 'title_override'

// Verifies the title is included in the metadata
assert head.select('meta[property="og:site_name"]').attr('content') == 'Title override – Overriden'
assert head.select('meta[property="og:title"]').attr('content') == 'Title override – Overriden'

// Verifies the Twitter metadata is generated
assert head.select('meta[name="twitter:title"]').attr('content') == 'Title override – Overriden'
