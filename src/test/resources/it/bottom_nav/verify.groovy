// This script verifies that a site contains the bottom navigation.

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

// Verifies the skin info is included

// Footer link
def div = body.select( 'footer #footer-info div' ).last()
assert div.html().contains( 'Rendered using' )

// The footer columns exist
def titles = body.select( 'footer dl dt' )
assert titles.size() == 3

// The footer columns contains the expected titles
assert titles.get(0).html().equals('General Info')
assert titles.get(1).html().equals('Code')
assert titles.get(2).html().equals('Releases')

// The footer columns data exists
def rows = body.select( 'footer dl dd' )
assert rows.size() == 7

rows = body.select( 'footer dl' )

// First column
def row = rows.get(0).select( 'dd' )
assert row.size() == 2

assert row.get(0).html().equals('<a href="./acquire.html" title="Acquire">Acquire</a>')
assert row.get(1).html().equals('<a href="./usage.html" title="Usage">Usage</a>')

// Second column
row = rows.get(1).select( 'dd' )
assert row.size() == 3

assert row.get(0).html().equals('<a href="https://github.com/Bernardo-MG/docs-maven-skin" title="SCM" class="link-noted">SCM <span class="note">GitHub</span></a>')
assert row.get(1).html().equals('<a href="https://travis-ci.org/Bernardo-MG/docs-maven-skin" title="CI" class="link-noted">CI <span class="note">Travis CI</span></a>')
assert row.get(2).html().equals('<a href="https://www.github.com/bernardo-mg/docs-maven-skin/issues" title="Issues" class="link-noted">Issues <span class="note">GitHub</span></a>')

// Third column
row = rows.get(2).select( 'dd' )
assert row.size() == 2

assert row.get(0).html().equals('<a href="https://bintray.com/bernardo-mg/maven/docs-maven-skin/view" title="Bintray">Bintray</a>')
assert row.get(1).html().equals('<a href="http://mvnrepository.com/artifact/com.bernardomg.maven.skins/docs-maven-skin" title="Maven Central">Maven Central</a>')
