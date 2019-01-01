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

// Verifies the menus exist
def dropdowns = body.select( '.dropdown-toggle' )
assert dropdowns.size() == 1

assert dropdowns.get(0).html().equals( 'Links <span class="chevron_toggleable fa fa-chevron-up" aria-hidden="true"></span>' );

// Verifies the menu links exist
assert html.contains( '<li><a href="http://www.apache.org" title="Apache">Apache</a></li>' )
assert html.contains( '<li><a href="https://maven.apache.org" title="Maven">Maven</a></li>' )
