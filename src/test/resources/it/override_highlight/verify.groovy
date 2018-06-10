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
def highlightInit = new File(basedir, 'target/site/js/initializeHighlight.js').text

// Verify the file content has been overriden
assert highlightInit.equals( 'overriden' )
