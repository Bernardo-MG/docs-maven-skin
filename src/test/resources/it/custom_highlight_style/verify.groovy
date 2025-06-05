// This script verifies a default highlight.js style can be applied

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// The custom highlight style is applied
def customStyle = parsed.head().select( 'link[href="./lib/highlight/styles/solarized-dark.css"]' )
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./lib/highlight/styles/solarized-dark.css">')
