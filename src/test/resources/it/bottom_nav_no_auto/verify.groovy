// This script verifies that a site contains the bottom navigation with no auto generated sections.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

// Verifies that all the files were created
[
    'target/site/index.html'
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

// Verifies the footer columns exist
def titles = body.select( 'dt' )
assert titles.size() == 3

// Verifies the footer columns contains the expected titles
assert titles.get(0).html().equals('General Info')

// Verifies the footer columns data
def rows = body.select( 'dd' )
assert rows.size() == 2

// First column
assert rows.get(0).html().equals('<a href="./acquire.html" title="Acquire">Acquire</a>')
assert rows.get(1).html().equals('<a href="./usage.html" title="Usage">Usage</a>')
