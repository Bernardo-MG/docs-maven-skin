// This script verifies that the default highlight.js style is applied when no customHighlightStyle
// is provided.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// The default highlight style is applied
def customStyle = parsed.head().select( 'link[href="./lib/highlight/styles/default.css"]' )
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./lib/highlight/styles/default.css">')
