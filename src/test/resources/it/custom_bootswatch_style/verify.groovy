// This script verifies the Bootswatch style can be changed

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// The custom highlight style is applied
def customStyle = parsed.head().select('link[href="./lib/bootswatch/dist/sketchy/bootstrap.min.css"]')
assert customStyle.size() == 1
assert customStyle.attr('rel') == 'stylesheet'