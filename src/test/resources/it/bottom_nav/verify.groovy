// This script verifies that a site contains the bottom navigation.

import org.jsoup.Jsoup
import java.util.logging.Logger

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

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

def link = row.get(0)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('./acquire.html')
assert link.attr( 'title' ).equals('Acquire')
assert item.attr( 'aria-label' ).equals('Acquire')
assert link.html().equals('Acquire')

link = row.get(1)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('./usage.html')
assert link.attr( 'title' ).equals('Usage')
assert item.attr( 'aria-label' ).equals('Usage')
assert link.html().equals('Usage')

// Second column
row = rows.get(1).select( 'dd' )
assert row.size() == 3

link = row.get(0)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://github.com/Bernardo-MG/docs-maven-skin')
assert link.attr( 'title' ).equals('SCM')
assert item.attr( 'aria-label' ).equals('SCM')
assert link.html().equals('SCM <span class="note">GitHub</span>')
assert link.hasClass( 'link-noted' )

link = row.get(1)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://github.com/Bernardo-MG/docs-maven-skin/actions')
assert link.attr( 'title' ).equals('CI')
assert item.attr( 'aria-label' ).equals('CI')
assert link.html().equals('CI <span class="note">Github workflow</span>')
assert link.hasClass( 'link-noted' )

link = row.get(2)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://www.github.com/bernardo-mg/docs-maven-skin/issues')
assert link.attr( 'title' ).equals('Issues')
assert item.attr( 'aria-label' ).equals('Issues')
assert link.html().equals('Issues <span class="note">GitHub</span>')
assert link.hasClass( 'link-noted' )

// Third column
row = rows.get(2).select( 'dd' )
assert row.size() == 2

link = row.get(0)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://bintray.com/bernardo-mg/maven/docs-maven-skin/view')
assert link.attr( 'title' ).equals('Bintray')
assert item.attr( 'aria-label' ).equals('Bintray')
assert link.html().equals('Bintray')

link = row.get(1)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('http://mvnrepository.com/artifact/com.bernardomg.maven.skins/docs-maven-skin')
assert link.attr( 'title' ).equals('Maven Central')
assert item.attr( 'aria-label' ).equals('Maven Central')
assert link.html().equals('Maven Central')
