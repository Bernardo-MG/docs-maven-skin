// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// The code sections were created with the correct tags
def codes = body.select('pre')
assert codes.size() == 3

// All <pre> blocks should have required classes
codes.each { code ->
    assert code.hasClass('border')
    assert code.hasClass('shadow')
    assert code.hasClass('rounded')
}

// The code sections were created with the correct tags
assert body.select('pre > code').size() == 3
