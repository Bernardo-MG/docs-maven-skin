// This script verifies that a site contains the bottom navigation.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

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

// Validate HTML
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

// Verifies the footer columns exist and contain the expected data
assert html.contains( '<dt>General Info</dt>' )
assert html.contains( '<dd><a href="./acquire.html" title="Acquire">Acquire</a></dd>' )
assert html.contains( '<dd><a href="./usage.html" title="Usage">Usage</a></dd>' )

assert html.contains( '<dt>Code</dt>' )
assert html.contains( '<dd><a href="https://github.com/Bernardo-MG/docs-maven-skin" title="SCM" class="link-noted">SCM <span class="note">GitHub</span></a></dd>' )
assert html.contains( '<dd><a href="https://travis-ci.org/Bernardo-MG/docs-maven-skin" title="CI" class="link-noted">CI <span class="note">Travis CI</span></a></dd>' )
assert html.contains( '<dd><a href="https://www.github.com/bernardo-mg/docs-maven-skin/issues" title="Issues" class="link-noted">Issues <span class="note">GitHub</span></a></dd>' )

assert html.contains( '<dt>Releases</dt>' )
assert html.contains( '<dd><a href="https://bintray.com/bernardo-mg/maven/docs-maven-skin/view" title="Bintray">Bintray</a></dd>' )
assert html.contains( '<dd><a href="http://mvnrepository.com/artifact/com.wandrell.maven.skins/docs-maven-skin" title="Maven Central">Maven Central</a></dd>' )
