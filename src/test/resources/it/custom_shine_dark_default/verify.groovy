// This script verifies the Bootswatch style can be changed

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// The default style is applied to the nav bar
def nav = body.select('#navbar-main')
assert nav.hasClass('bg-primary')
assert nav.attr('data-bs-theme') == 'primary'

// The default style is applied to the footer
def footer = body.select('footer')
assert footer.hasClass('bg-primary')
assert footer.attr('data-bs-theme') == 'primary'

// The default style is applied to the footer info
def footerinfo = body.select('#footer-info')
assert footerinfo.hasClass('bg-primary')
