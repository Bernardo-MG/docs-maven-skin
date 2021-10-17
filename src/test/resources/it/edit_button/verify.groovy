// This script verifies that a minimal site contains only the barebones of a site.

import com.jcabi.w3c.ValidatorBuilder
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Validates HTML 5
def htmlResponse = new ValidatorBuilder().html().validate(html)

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies the edition link was created
def edit = body.select( 'a > span.fa-edit' ).first().parent()
assert edit.attr( 'href' ).equals( 'https://github.com/Bernardo-MG/docs-maven-skin/src/site/markdown/index.md' )
