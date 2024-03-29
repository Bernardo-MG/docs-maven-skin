// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies the edition link was created
def edit = body.select( 'a > span.fa-pen-to-square' ).first().parent()
assert edit.attr( 'href' ).equals( 'https://github.com/Bernardo-MG/docs-maven-skin/src/site/markdown/index.md' )
