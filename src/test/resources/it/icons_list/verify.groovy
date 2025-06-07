// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies the icon in the navbar
assert body.select('#navbar-icons a').size() == 1

def link = icons.first()
assert link.tagName() == 'a'
assert link.attr('href') == 'https://github.com/Bernardo-MG/docs-maven-skin'
assert link.attr('title') == 'GitHub'
assert link.attr('aria-label') == 'GitHub'

// Checking inner HTML exactly as expected
assert link.html() == '<span class="fa-brands fa-github" aria-hidden="true"></span> <span class="d-none d-sm-block d-md-none"> GitHub</span>'
