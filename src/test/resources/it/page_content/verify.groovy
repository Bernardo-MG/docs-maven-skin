// This script verifies that a minimal site contains only the barebones of a site.

import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def parsed = Jsoup.parse(html)

def body = parsed.body()
def main = body.select('main')

// Verifies the heading uses the correct text
def titleHeading = main.select( 'h1' ).first()
assert titleHeading.html().contains( 'Page Content' )
assert titleHeading.id().equals( 'Page-Content' )

def subHeadings = main.select( 'h2' )

// Verifies the first subsection uses the correct text
def firstSubHeading = subHeadings.get(0)
assert firstSubHeading.html().contains( 'Subsection' )
assert firstSubHeading.id().equals( 'Subsection' )

// Verifies the second subsection uses the correct text
def secondSubHeading = subHeadings.get(1)
assert secondSubHeading.html().contains( 'Second Subsection' )
assert secondSubHeading.id().equals( 'Second-Subsection' )

def subSubHeadings = body.select( 'h3' )

// Verifies the first subsection uses the correct text
def firstSubSubHeading = subSubHeadings.first()
assert firstSubSubHeading.html().contains( 'Smaller subsection' )
assert firstSubSubHeading.id().equals( 'Smaller-subsection' )

// Verifies the number of sections is correct
def mainSections = body.select( 'main > section' )
assert mainSections.size() == 1

// Verifies the number of subsections is correct
def subSections = mainSections.first().select( '> section' )
assert subSections.size() == 1
def subSubSections = subSections.first().select( '> section' )
assert subSubSections.size() == 2
assert subSubSections.get(0).select( '> section' ).size() == 1
assert subSubSections.get(1).select( '> section' ).size() == 0

// Verifies subsection anchors
def anchors = main.select( 'a' )

assert anchors.get(0).id().equals( 'Page_Content' )
assert anchors.get(1).id().equals( 'Subsection' )
assert anchors.get(2).id().equals( 'Smaller_subsection' )
assert anchors.get(3).id().equals( 'Second_Subsection' )
