// This script verifies the default Bootswatch style is applied

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
def parsed = Jsoup.parse(html)
def head = parsed.head()

// The custom highlight style is applied
def customStyle = head.select( 'link[href="./lib/bootswatch/dist/litera/bootstrap.min.css"]' )
assert customStyle.outerHtml().equals('<link rel="stylesheet" href="./lib/bootswatch/dist/litera/bootstrap.min.css">')
