import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def body = Jsoup.parse(html).body()

// Verify the number of dropdown toggles (menus)
assert body.select('#navbar-main-menu .dropdown-toggle').size() == 12

// Verify dropdown menus exist
def dropdowns = body.select('#navbar-main-menu .dropdown')
assert dropdowns.size() > 0

// Verify the number of dropdown items in the first dropdown menu
assert dropdowns.get(0).select('.dropdown-item').size() == 10