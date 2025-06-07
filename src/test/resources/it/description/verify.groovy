// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

def body = parsed.body()
def head = parsed.head()

// The heading is set correctly
assert body.select('#main-section header').html().trim() == '<h1 id="With-description">With description</h1>'

// The title is included in the HTML head
assert head.select('title').text() == 'With description – Project with description'

// The title is included in the header navigation
def titleHeader = body.select('#navbar-main a.navbar-brand').first()
assert titleHeader.tagName() == 'a'
assert titleHeader.attr('href') == './index.html'
assert titleHeader.hasClass('navbar-brand')
assert titleHeader.text() == 'Project with description'

// The Open Graph site name metadata is set correctly
def metaOgSite = head.select('meta[property="og:site_name"]')
assert metaOgSite.attr('content').trim() == 'With description – Project with description'

// The Open Graph title metadata is set correctly
def metaOgTitle = head.select('meta[property="og:title"]')
assert metaOgTitle.attr('content').trim() == 'With description – Project with description'

// The Twitter title metadata is set correctly
def metaTwTitle = head.select('meta[name="twitter:title"]')
assert metaTwTitle.attr('content').trim() == 'With description – Project with description'
