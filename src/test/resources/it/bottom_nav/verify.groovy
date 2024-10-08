// This script verifies that a site contains the bottom navigation.

import org.jsoup.Jsoup
import java.util.logging.Logger
import java.time.Year

// Acquires the sample HTML content
def html = new File(basedir, 'target/site/index.html').text

// Parses HTML
def body = Jsoup.parse(html).body()

// Verifies the skin info is included

// Footer info
def footerInfo = body.select( '#footer-info' )

def copyrightInfo = footerInfo.select( 'div' ).first()
assert copyrightInfo.text().contains( Year.now().toString() + ' Bernardo Martinez Garrido - MIT License' )

def copyrightIcon = copyrightInfo.select( '.fa-copyright' )
assert copyrightIcon.size() == 1

def renderedInfo = footerInfo.select( 'div' ).last()
assert renderedInfo.text().contains( 'Rendered using Docs Maven Skin' )

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
assert link.attr( 'aria-label' ).equals('Acquire')
assert link.html().equals('Acquire')

link = row.get(1)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('./usage.html')
assert link.attr( 'title' ).equals('Usage')
assert link.attr( 'aria-label' ).equals('Usage')
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
assert link.attr( 'aria-label' ).equals('SCM')
assert link.html().equals('SCM <span class="note">GitHub</span>')
assert link.hasClass( 'link-noted' )

link = row.get(1)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://github.com/Bernardo-MG/docs-maven-skin/actions')
assert link.attr( 'title' ).equals('CI')
assert link.attr( 'aria-label' ).equals('CI')
assert link.html().equals('CI <span class="note">GitHub workflow</span>')
assert link.hasClass( 'link-noted' )

link = row.get(2)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://www.github.com/bernardo-mg/docs-maven-skin/issues')
assert link.attr( 'title' ).equals('Issues')
assert link.attr( 'aria-label' ).equals('Issues')
assert link.html().equals('Issues <span class="note">GitHub</span>')
assert link.hasClass( 'link-noted' )

// Third column
row = rows.get(2).select( 'dd' )
assert row.size() == 2

link = row.get(0)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('http://mvnrepository.com/artifact/com.bernardomg.maven.skins/docs-maven-skin')
assert link.attr( 'title' ).equals('Maven Central')
assert link.attr( 'aria-label' ).equals('Maven Central')
assert link.html().equals('Maven Central')

link = row.get(1)
assert link.tag().normalName().equals('dd')
link = link.children().first()
assert link.tag().normalName().equals('a')
assert link.attr( 'href' ).equals('https://github.com/Bernardo-MG?tab=packages&repo_name=docs-maven-skin')
assert link.attr( 'title' ).equals('GitHub')
assert link.attr( 'aria-label' ).equals('GitHub')
assert link.html().equals('GitHub')
