// This script verifies a custom style can be provided

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def head = parsed.head()

// The custom style file is linked
def customStyle = head.select( 'link[href="./css/custom.css"]' )
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./css/custom.css">')