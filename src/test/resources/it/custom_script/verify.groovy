// This script verifies that a the highlight.js initialization file can be overriden.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def parsed = Jsoup.parse(html)
def body = parsed.body()

// The custom script file is linked
def customScript = body.select( 'script[src="./js/custom.js"]' )
assert customScript.outerHtml().equals('<script src="./js/custom.js"></script>')
