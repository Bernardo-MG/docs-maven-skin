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
def parsed = Jsoup.parse(html)
def body = parsed.body()
def head = parsed.head()

// Verifies that the footer menus are not generated
def navbarFooter = body.select( '#navbar-footer' )
assert navbarFooter.isEmpty()

// Verifies that the icon menus are not generated
def iconMenu = body.select( '#navbar-main-menu a' )
assert iconMenu.isEmpty()

// Verifies that the right navigation bar was not generated
def rightNavBar = body.select( '#navbar-main-menu .dropdown-toggle' )
assert rightNavBar.isEmpty()
