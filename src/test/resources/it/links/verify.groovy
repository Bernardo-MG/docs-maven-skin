import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verify the menu dropdown toggle
def dropdowns = body.select('#navbar-main-menu .dropdown-toggle')
assert dropdowns.size() == 1

def dropdown = dropdowns.first()
assert dropdown.tag().normalName() == 'a'
assert dropdown.id() == 'links_menu'
assert dropdown.attr('href') == '#'
assert dropdown.attr('data-bs-toggle') == 'dropdown'
assert dropdown.attr('role') == 'button'
assert dropdown.attr('aria-haspopup') == 'true'
assert dropdown.attr('aria-expanded') == 'false'
assert dropdown.html() == 'Links'
assert dropdown.hasClass('nav-link')
assert dropdown.hasClass('dropdown-toggle')

// Verify the dropdown menu items
def items = body.select('#navbar-main-menu .dropdown-item')
def expectedItems = [
    [href: 'http://www.apache.org', title: 'Apache', ariaLabel: 'Apache', html: 'Apache'],
    [href: 'https://maven.apache.org', title: 'Maven', ariaLabel: 'Maven', html: 'Maven']
]

assert items.size() == expectedItems.size()

items.eachWithIndex { item, i ->
    def expected = expectedItems[i]
    assert item.attr('href') == expected.href
    assert item.attr('title') == expected.title
    assert item.attr('aria-label') == expected.ariaLabel
    assert item.html() == expected.html
    assert item.hasClass('dropdown-item')
}

assert true