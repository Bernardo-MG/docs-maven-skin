// This script verifies a default highlight.js style can be applied

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def head = parsed.head()

// The custom highlight style is applied
def customStyle = head.select( 'link[href="./lib/highlight/styles/solarized-dark.css"]' )
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./lib/highlight/styles/solarized-dark.css">')
