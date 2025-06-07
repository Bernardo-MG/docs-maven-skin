// This script verifies that a the highlight.js initialization file can be overriden.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

// The custom script file is linked
def customScript = parsed.body().select('script[src="./js/custom.js"]')
assert customScript.size() == 1