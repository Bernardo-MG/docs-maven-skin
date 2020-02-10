// This script verifies that a minimal site contains only the barebones of a site.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup

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

// The code sections were created with the correct tags
def codes = body.select( 'pre' )
assert codes.size() == 3

def code = codes.get(0)
assert code.hasClass( 'border' )
assert code.hasClass( 'shadow' )
assert code.hasClass( 'rounded' )

code = codes.get(1)
assert code.hasClass( 'border' )
assert code.hasClass( 'shadow' )
assert code.hasClass( 'rounded' )

code = codes.get(2)
assert code.hasClass( 'border' )
assert code.hasClass( 'shadow' )
assert code.hasClass( 'rounded' )

// The code sections were created with the correct tags
codes = body.select( 'pre > code' )
assert codes.size() == 3
