import org.jsoup.Jsoup

// Check required files exist
def requiredFiles = [
    'target/site/index.html',
    'target/site/favicon.ico',
    'target/site/robots.txt'
]

// Collect missing files
def missingFiles = requiredFiles.findAll { !new File(basedir, it).exists() }

// Fail if any are missing
if (!missingFiles.isEmpty()) {
    throw new IllegalStateException("Missing files: ${missingFiles.join(', ')}")
}

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)
def body = parsed.body()
def head = parsed.head()

// Header section
def header = body.select('section > header').first()
assert header.hasClass('pb-2')
assert header.hasClass('mt-4')
assert header.hasClass('mb-2')
assert header.hasClass('border-bottom')

// Title in <head>
assert head.select('title').text() == 'Minimal page – minimal-site'

// Title in navbar
def titleHeader = body.select('#navbar-main a.navbar-brand')
assert titleHeader.text() == 'minimal-site'
assert titleHeader.attr('href') == './index.html'

// Version and date
assert body.select('#navbar-version').text() =~ /1\.0\.0/
assert body.select('#navbar-date').text() =~ /\d{4}-\d{2}-\d{2}/

// Footer link
def footerInfo = body.select('footer #footer-info div').last()
assert footerInfo.text().contains('Rendered using')
assert html.contains('Rendered using <a href="https://github.com/Bernardo-MG/docs-maven-skin">Docs Maven Skin</a>')

// HTML comments
assert html.contains('Rendered using Docs Maven Skin')
assert html.contains('Generated by Apache Maven Doxia')

// Favicon
assert html.contains('<link href="./favicon.ico" rel="shortcut icon" type="image/x-icon">')

// Absence of optional/custom elements
assert body.select('#footer-custom-content').isEmpty()
assert head.select('link[href="./css/custom.css"]').isEmpty()
assert body.select('script[src="./js/custom.js"]').isEmpty()
assert body.select('#navbar-footer').isEmpty()
assert body.select('#navbar-main-menu a').isEmpty()
assert body.select('#navbar-main-menu .dropdown-toggle').isEmpty()
assert head.select('a > span.fa-pen-to-square').isEmpty()
