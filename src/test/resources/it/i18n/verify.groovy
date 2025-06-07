// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/es/index.html').text
def parsed = Jsoup.parse(html)
def body = parsed.body()

// Verifies the heading is set inside a section header
assert body.select('section > header').first() != null

// Verifies the title is included in the HTML head
assert parsed.head().select('title').text() == 'P[á]gina internacionalizada – i18n-site'

// Verifies the title is included in the navbar header
assert body.select('#navbar-main a.navbar-brand').text() == 'i18n-site'

// Verifies the project version is included
def versionHeader = body.select('#navbar-version')
assert (versionHeader.text() =~ /1\.0\.0/).find()

// Verifies the project date is included
def dateHeader = body.select('#navbar-date')
assert (dateHeader.text() =~ /\d{4}-\d{2}-\d{2}/).find()

// Footer link contains expected text and link
assert body.select('footer #footer-info div').last().text().contains('Rendered using')
assert html.contains('Rendered using <a href="https://github.com/Bernardo-MG/docs-maven-skin">Docs Maven Skin</a>')

// Verifies the main heading contains expected text
assert body.select('h1').text().contains('internacionalizada')