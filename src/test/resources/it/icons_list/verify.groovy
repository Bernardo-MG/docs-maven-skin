// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies the icon in the navbar
// def icons = body.select( '#navbar-main-menu a' )
def icons = body.select( '.navbar-icon' )
assert icons.size() == 1

def link = icons.first().parent()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://github.com/Bernardo-MG/docs-maven-skin')
assert link.attr( 'title' ).equals('Github')
assert link.attr( 'aria-label' ).equals('Github')
assert link.html().equals('<span class="navbar-icon fab fa-github ps-1" aria-hidden="true"></span> <span class="d-none d-sm-block d-md-none"> Github</span>')
