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

// Images
def fig = body.select( 'figure' ).first()

def firstImg = fig.select( 'img' ).first()
assert firstImg.attr( 'src' ).contains( './images/example_class_diagram.png' )
assert firstImg.attr( 'alt' ).contains( 'Dice class diagram' )
assert firstImg.attr( 'class' ).contains( 'img-fluid' )

def firstCaption = fig.select( 'figcaption' ).first()
assert firstCaption.html().contains( 'Dice class diagram' )
