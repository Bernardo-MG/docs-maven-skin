import org.jsoup.Jsoup

// Parse HTML
def html = new File(basedir, 'target/site/index.html').text
def head = Jsoup.parse(html).head()

// Basic metadata
assert head.select('meta[charset="utf-8"]') != null
assert head.select('meta[name="viewport"]').attr('content') == 'width=device-width, initial-scale=1, shrink-to-fit=no'

// General metadata should not be generated
assert head.select('meta[name="description"]').isEmpty()
assert head.select('meta[name="keywords"]').isEmpty()
assert head.select('meta[name="author"]').isEmpty()

// Facebook Open Graph metadata
assert head.select('meta[property="og:type"]').attr('content') == 'website'
assert head.select('meta[property="og:url"]').isEmpty()
assert head.select('meta[property="og:site_name"]').attr('content') == 'Metadata minimal page – metadata-minimal-site'
assert head.select('meta[property="og:title"]').attr('content') == 'Metadata minimal page – metadata-minimal-site'
assert head.select('meta[property="og:description"]').isEmpty()

// Twitter metadata
assert head.select('meta[name="twitter:card"]').attr('content') == 'summary'
assert head.select('meta[name="twitter:creator"]').isEmpty()
assert head.select('meta[name="twitter:title"]').attr('content') == 'Metadata minimal page – metadata-minimal-site'
assert head.select('meta[name="twitter:description"]').isEmpty()