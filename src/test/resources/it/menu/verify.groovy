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
assert dropdowns.size() == 2

assert dropdowns.get(0).outerHtml().equals( '<a href="#" class="nav-link dropdown-toggle" id="Documentation_menu" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Documentation</a>' );
assert dropdowns.get(1).outerHtml().equals( '<a href="#" class="nav-link dropdown-toggle" id="Info_and_reports_menu" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Info and reports</a>' );

// Verifies the menu links exist
assert html.contains( '<a class="dropdown-item" href="./acquire.html" title="Acquire">Acquire</a>' )
assert html.contains( '<a class="dropdown-item" href="./usage.html" title="Usage">Usage</a>' )
