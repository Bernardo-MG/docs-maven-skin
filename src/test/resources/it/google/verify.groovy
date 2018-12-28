// This script verifies that the Google options are applied correctly.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup

// Verifies that all the files were created
[
    'target/site/index.html',
    'target/site/favicon.ico',
    'target/site/robots.txt',
    'target/site/css/style.min.css',
    'target/site/js/scripts.min.js'
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

// Validates HTML 5
def htmlResponse = new ValidatorBuilder().html().validate(html)

MatcherAssert.assertThat(
    'There are errors',
    htmlResponse.errors(),
    Matchers.describedAs(htmlResponse.toString(), Matchers.hasSize(0))
)
MatcherAssert.assertThat(
    'There are warnings',
    htmlResponse.warnings(),
    Matchers.describedAs(htmlResponse.toString(), Matchers.hasSize(0))
)

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies Google Analytics was set up
assert html.contains( 'Google Analytics' )

def googleAnalyticsScript = body.select( 'script[src="https://www.googletagmanager.com/gtag/js?id=abcd"]' )
assert googleAnalyticsScript != null
