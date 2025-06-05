// This script verifies the default Bootswatch style is applied

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// The custom highlight style is applied
def customStyle = parsed.head().select( 'link[href="./lib/bootswatch/dist/litera/bootstrap.min.css"]' )
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./lib/bootswatch/dist/litera/bootstrap.min.css">')
