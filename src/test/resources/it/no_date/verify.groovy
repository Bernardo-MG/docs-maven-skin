// This script verifies that a minimal site contains only the barebones of a site.

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies the project version is included
def versionHeader = body.select( '#navbar-version' )
assert versionHeader.html() =~ /1\.0\.0/

// Verifies the project date is included
def dateHeader = body.select( '#navbar-date' )
assert dateHeader.isEmpty()
