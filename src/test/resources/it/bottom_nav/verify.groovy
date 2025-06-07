// This script verifies that a site contains the bottom navigation.

import org.jsoup.Jsoup
import java.time.Year

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// The footer info is unchanged by the menu
def footerInfo = body.select('#footer-info')

def copyrightInfo = footerInfo.select('div').first()
assert copyrightInfo.text().contains( Year.now().toString() + ' Bernardo Martinez Garrido - MIT License')
assert copyrightInfo.select('.fa-copyright').size() == 1

def renderedInfo = footerInfo.select('div').last()
assert renderedInfo.text().contains('Rendered using Docs Maven Skin')

// Check bottom nav columns
def titles = body.select('footer dl dt')*.html()
assert titles == ['General Info', 'Code', 'Releases']

def expectedLinks = [
    [ // General Info
        [href: './acquire.html', title: 'Acquire'],
        [href: './usage.html', title: 'Usage']
    ],
    [ // Code
        [href: 'https://github.com/Bernardo-MG/docs-maven-skin', title: 'SCM'],
        [href: 'https://github.com/Bernardo-MG/docs-maven-skin/actions', title: 'CI'],
        [href: 'https://www.github.com/bernardo-mg/docs-maven-skin/issues', title: 'Issues']
    ],
    [ // Releases
        [href: 'http://mvnrepository.com/artifact/com.bernardomg.maven.skins/docs-maven-skin', title: 'Maven Central'],
        [href: 'https://github.com/Bernardo-MG?tab=packages&repo_name=docs-maven-skin', title: 'GitHub']
    ]
]

def columns = body.select('footer dl')
assert columns.size() == 3

columns.eachWithIndex { col, i ->
    def links = col.select('dd a')
    def expectedLink = expectedLinks[i]
    assert links.size() == expectedLink.size()
    links.eachWithIndex { a, j ->
        def exp = expectedLink[j]
        assert a.attr('href') == exp.href
        assert a.attr('title') == exp.title
        assert a.attr('aria-label') == exp.title
        assert a.html() == exp.title
    }
}

assert true
