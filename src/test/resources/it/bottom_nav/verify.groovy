// This script verifies that a site contains the bottom navigation.

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

// Verifies the skin info is included

def div = body.select( 'footer.footer div.row div' ).last()

// Skin info
assert div.html().contains( 'Rendered using' )

// Verifies the footer columns exist
def titles = body.select( 'dt' )
assert titles.size() == 3

// Verifies the footer columns contains the expected titles
assert titles.get(0).html().equals('General Info')
assert titles.get(1).html().equals('Code')
assert titles.get(2).html().equals('Releases')

// Verifies the footer columns data
def rows = body.select( 'dd' )

// First column
assert rows.get(0).html().equals('<a href="./acquire.html" title="Acquire">Acquire</a>')
assert rows.get(1).html().equals('<a href="./usage.html" title="Usage">Usage</a>')

// Second column
assert rows.get(2).html().equals('<a href="https://github.com/Bernardo-MG/docs-maven-skin" title="SCM" class="link-noted">SCM <span class="note">GitHub</span></a>')
assert rows.get(3).html().equals('<a href="https://travis-ci.org/Bernardo-MG/docs-maven-skin" title="CI" class="link-noted">CI <span class="note">Travis CI</span></a>')
assert rows.get(4).html().equals('<a href="https://www.github.com/bernardo-mg/docs-maven-skin/issues" title="Issues" class="link-noted">Issues <span class="note">GitHub</span></a>')

// Third column
assert rows.get(5).html().equals('<a href="https://bintray.com/bernardo-mg/maven/docs-maven-skin/view" title="Bintray">Bintray</a>')
assert rows.get(6).html().equals('<a href="http://mvnrepository.com/artifact/com.wandrell.maven.skins/docs-maven-skin" title="Maven Central">Maven Central</a>')
