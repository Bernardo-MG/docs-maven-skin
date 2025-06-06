// This script verifies that a the highlight.js initialization file can be overriden.

import org.jsoup.Jsoup

// Verifies that the file was created
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

// Get highlight content
def highlightInit = new File(basedir, 'target/site/js/initializeHighlight.js').text

// Verify the file content has been overriden
assert highlightInit.equals('overriden')
