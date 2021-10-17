// This script verifies that a minimal site contains only the barebones of a site.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/es/index.html').text

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
def parsed = Jsoup.parse(html)
def body = parsed.body()
def head = parsed.head()

// Verified the heading is set
// Verified the heading is set
def header = body.select( 'section > header' ).first()
assert header != null

// Verifies the title is included in the HTML head
def title = head.select( 'title' )
assert title.html().equals( 'i18n-site – Página internacionalizada' )

// Verifies the title is included in the header
def titleHeader = body.select( '#navbar-main a.navbar-brand' )
assert titleHeader.html().equals( 'i18n-site' )

// Verifies the project version is included
def versionHeader = body.select( '#navbar-version' )
assert versionHeader.html() =~ /1\.0\.0/

// Verifies the project date is included
def dateHeader = body.select( '#navbar-date' )
assert dateHeader.html() =~ /[0-9]+-[0-9]+-[0-9]+/

// Footer link
def div = body.select( 'footer #footer-info div' ).last()
assert div.html().contains( 'Rendered using' )
assert html.contains( 'Rendered using <a href="https://github.com/Bernardo-MG/docs-maven-skin">Docs Maven Skin</a>' )

// Verifies the heading uses the correct text
def titleHeading = body.select( 'h1' )
assert titleHeading.html().contains( 'internacionalizada' )
