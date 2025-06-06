// This script verifies the Bootswatch style can be changed

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// The default style is applied to the nav bar
def nav = body.select('#navbar-main')
assert nav.hasClass('bg-light')
assert nav.hasAttr('data-bs-theme')
assert nav.attr('data-bs-theme').equals('light')

// The default style is applied to the footer
def footer = body.select('footer')
assert footer.hasClass('bg-light')
assert footer.hasAttr('data-bs-theme')
assert footer.attr('data-bs-theme').equals('light')

def footerinfo = body.select('#footer-info')
assert footerinfo.hasClass('bg-light')
