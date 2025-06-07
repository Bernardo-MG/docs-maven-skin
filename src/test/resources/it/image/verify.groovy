// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)
def figs = parsed.body().select('figure')

// Helper to check figure classes
def checkFigureClasses = { fig ->
    assert fig.hasClass('shadow')
    assert fig.hasClass('bg-white')
    assert fig.hasClass('rounded')
    assert fig.hasClass('p-2')
}

// Standard image
def fig = figs[0]
checkFigureClasses(fig)

def img = fig.select('img').first()
assert img.attr('src').contains('./images/example_class_diagram.png')
assert img.attr('alt').contains('Dice class diagram')
assert img.hasClass('img-fluid')

def caption = fig.select('figcaption').first()
assert caption.html().contains('Dice class diagram')
assert caption.hasClass('font-italic')

// Image without name
fig = figs[1]
checkFigureClasses(fig)

img = fig.select('img').first()
assert img.attr('src').contains('./images/example_class_diagram.png')
assert img.attr('alt').isEmpty()
assert img.hasClass('img-fluid')

def captions = fig.select('figcaption')
assert captions.isEmpty()

// Missing image
fig = figs[2]
checkFigureClasses(fig)

img = fig.select('img').first()
assert img.attr('src').contains('./images/missing.jpg')
assert img.attr('alt').contains('Missing image')
assert img.hasClass('img-fluid')

caption = fig.select('figcaption').first()
assert caption.html().contains('Missing image')
assert caption.hasClass('font-italic')