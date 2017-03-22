// This script verifies that a minimal site contains only the barebones of a site.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup

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

// Verifies the icon menus exist
def icons = body.select( 'ul.icons-list' )
assert icons.size() == 1

// Verifies the icon in the list
def iconMenu = body.select( 'ul.icons-list > li' )
assert iconMenu.size() == 1

assert icons.get(0).html().equals('<a href="https://github.com/Bernardo-MG/docs-maven-skin" title="Github" aria-label="Github"><span class="navbar-icon fa fa-github" aria-hidden="true"></span> <span class="hidden-md hidden-lg"> Github</span></a>')
