// This script verifies that the Google options are applied correctly.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Validates HTML 5
def htmlResponse = new ValidatorBuilder().html().validate(html)

MatcherAssert.assertThat(
    'There are errors',
    htmlResponse.errors(),
    Matchers.describedAs(htmlResponse.toString(), Matchers.hasSize(0))
)

Logger logger = Logger.getLogger("")
htmlResponse.warnings().each{ value -> 
	logger.warning( value.toString() )
}

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies Google Analytics was set up
assert html.contains( 'Google Analytics' )

def googleAnalyticsScript = body.select( 'script[src="https://www.googletagmanager.com/gtag/js?id=abcd"]' )
assert googleAnalyticsScript != null
