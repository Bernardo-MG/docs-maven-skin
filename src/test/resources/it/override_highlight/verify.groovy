// This script verifies that the highlight.js initialization file can be overridden.

import org.jsoup.Jsoup

// Verify that the initialization file exists
def highlightFile = new File(basedir, 'target/site/js/initializeHighlight.js')
if (!highlightFile.exists()) {
    throw new IllegalStateException("File ${highlightFile} doesn't exist")
}

// Verify the file content has been overridden
assert highlightFile.text == 'overriden'
