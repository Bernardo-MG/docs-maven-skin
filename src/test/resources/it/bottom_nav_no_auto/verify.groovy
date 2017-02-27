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

// Verifies the footer columns exist and contain the expected data
assert html.contains( '<dt>General Info</dt>' )
assert html.contains( '<dd><a href="./acquire.html" title="Acquire">Acquire</a></dd>' )
assert html.contains( '<dd><a href="./usage.html" title="Usage">Usage</a></dd>' )

assert !html.contains( '<dt>Code</dt>' )

assert !html.contains( '<dt>Releases</dt>' )
