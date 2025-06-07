import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verify menus exist
def toggles = body.select('#navbar-main-menu .dropdown-toggle')
assert toggles.size() == 2

// Data to verify for menus
def expectedMenus = [
    [id: 'Documentation_menu', label: 'Documentation'],
    [id: 'Info_and_reports_menu', label: 'Info and reports']
]

toggles.eachWithIndex { toggle, i ->
    def expected = expectedMenus[i]
    assert toggle.tag().normalName() == 'a'
    assert toggle.id() == expected.id
    assert toggle.attr('href') == '#'
    assert toggle.attr('data-bs-toggle') == 'dropdown'
    assert toggle.attr('role') == 'button'
    assert toggle.attr('aria-haspopup') == 'true'
    assert toggle.attr('aria-expanded') == 'false'
    assert toggle.html() == expected.label
    assert toggle.hasClass('nav-link')
    assert toggle.hasClass('dropdown-toggle')
}

// Verify dropdown items
def dropdowns = body.select('#navbar-main-menu .dropdown')

def expectedLinks = [
    [
        [href: './acquire.html', title: 'Acquire', label: 'Acquire'],
        [href: './usage.html', title: 'Usage', label: 'Usage']
    ],
    [
        [href: './info.html', title: 'Info', label: 'Info']
    ]
]

dropdowns.eachWithIndex { dropdown, i ->
    def items = dropdown.select('.dropdown-item')
    def expectedItems = expectedLinks[i]
    assert items.size() == expectedItems.size()
    
    items.eachWithIndex { item, j ->
        def expected = expectedItems[j]
        assert item.attr('href') == expected.href
        assert item.attr('title') == expected.title
        assert item.attr('aria-label') == expected.label
        assert item.html() == expected.label
        assert item.hasClass('dropdown-item')
    }
}
