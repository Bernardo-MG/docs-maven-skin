// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

def body = parsed.body()
def main = body.select('main')

// Verifies the heading uses the correct text
def titleHeading = main.select('h1').first()
assert titleHeading.html().contains('Page Content')
assert titleHeading.id() == 'Page-Content'

def subHeadings = main.select('h2')

// Verifies the first subsection uses the correct text
def firstSubHeading = subHeadings[0]
assert firstSubHeading.html().contains('Subsection')
assert firstSubHeading.id() == 'Subsection'

// Verifies the second subsection uses the correct text
def secondSubHeading = subHeadings[1]
assert secondSubHeading.html().contains('Second Subsection')
assert secondSubHeading.id() == 'Second-Subsection'

def subSubHeadings = body.select('h3')

// Verifies the first sub-subsection uses the correct text
def firstSubSubHeading = subSubHeadings.first()
assert firstSubSubHeading.html().contains('Smaller subsection')
assert firstSubSubHeading.id() == 'Smaller-subsection'

// Verifies the number of sections is correct
def mainSections = body.select('main > section')
assert mainSections.size() == 1

// Verifies the number of subsections is correct
def subSections = mainSections.first().select('> section')
assert subSections.size() == 1

def subSubSections = subSections.first().select('> section')
assert subSubSections.size() == 2
assert subSubSections[0].select('> section').size() == 1
assert subSubSections[1].select('> section').size() == 0

// Verifies subsection anchors
def anchors = main.select('a')
assert anchors[0].id() == 'Page_Content'
assert anchors[1].id() == 'Subsection'
assert anchors[2].id() == 'Smaller_subsection'
assert anchors[3].id() == 'Second_Subsection'
