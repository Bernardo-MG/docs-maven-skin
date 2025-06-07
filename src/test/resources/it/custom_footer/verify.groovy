// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies that the footer custom content was generated
def footerContent = body.select('#footer-custom-content').text()
assert footerContent == 'Custom footer content'
