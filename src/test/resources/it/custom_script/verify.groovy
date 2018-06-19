// This script verifies that a the highlight.js initialization file can be overriden.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup

// Verifies that all the files were created
[
    'target/site/js/initializeHighlight.js'
].each {
    def file = new File(basedir, it)
    if (!file.exists()) {
        throw new IllegalStateException(
            "file ${file} doesn't exist"
        )
    }
}

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()
def head = Jsoup.parse(html).head()

// Verifies that the custom style file is linked
def customStyle = head.select( 'link[href="./css/custom.css"]' )
assert customStyle != null

// Verifies that the custom script file is linked
def customScript = body.select( 'script[src="./js/custom.js"]' )
assert customScript != null
