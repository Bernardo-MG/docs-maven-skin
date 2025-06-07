// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies the edition link was created
def editIcon = body.select('a > span.fa-pen-to-square').first()
assert editIcon != null

def editLink = editIcon.parent()
assert editLink.attr('href') == 'https://github.com/Bernardo-MG/docs-maven-skin/src/site/markdown/index.md'