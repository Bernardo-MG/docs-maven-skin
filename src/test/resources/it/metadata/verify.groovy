import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def head = Jsoup.parse(html).head()

// Basic metadata
assert head.select('meta[charset="utf-8"]') != null
assert head.select('meta[name="viewport"]').attr('content') == 'width=device-width, initial-scale=1, shrink-to-fit=no'

// General metadata
assert head.select('meta[name="description"]').attr('content') == 'Check the documentation for the example'
assert head.select('meta[name="keywords"]').attr('content') == 'Maven, Java, library'
assert head.select('meta[name="author"]').attr('content') == 'Bernardo Martínez Garrido'

// Facebook Open Graph metadata
assert head.select('meta[property="og:type"]').attr('content') == 'website'
assert head.select('meta[property="og:url"]').attr('content') == 'http://canonicallink'
assert head.select('meta[property="og:site_name"]').attr('content') == 'Metadata page – metadata-site'
assert head.select('meta[property="og:title"]').attr('content') == 'Metadata page – metadata-site'
assert head.select('meta[property="og:description"]').attr('content') == 'Check the documentation for the example'

// Twitter metadata
assert head.select('meta[name="twitter:card"]').attr('content') == 'summary'
assert head.select('meta[name="twitter:creator"]').attr('content') == '@bmg'
assert head.select('meta[name="twitter:title"]').attr('content') == 'Metadata page – metadata-site'
assert head.select('meta[name="twitter:description"]').attr('content') == 'Check the documentation for the example'