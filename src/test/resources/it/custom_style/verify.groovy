// This script verifies a custom style can be provided

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// The custom style file is linked
def customStyle = parsed.head().select('link[href="./css/custom.css"]')
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./css/custom.css">')