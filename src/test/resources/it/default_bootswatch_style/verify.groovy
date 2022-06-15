// This script verifies the default Bootswatch style is applied

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def head = parsed.head()

// The custom highlight style is applied
def customStyle = head.select( 'link[href="./lib/bootswatch/dist/litera/bootstrap.min.css"]' )
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./lib/bootswatch/dist/litera/bootstrap.min.css">')
