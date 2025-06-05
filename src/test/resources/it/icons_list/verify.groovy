// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verifies the icon in the navbar
def icons = body.select( '#navbar-icons a' )
assert icons.size() == 1

def link = icons.first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://github.com/Bernardo-MG/docs-maven-skin')
assert link.attr( 'title' ).equals('GitHub')
assert link.attr( 'aria-label' ).equals('GitHub')
assert link.html().equals('<span class="fa-brands fa-github" aria-hidden="true"></span> <span class="d-none d-sm-block d-md-none"> GitHub</span>')
