// This script verifies that a site contains the bottom navigation with no auto generated sections.

// The files to test are read
File index = new File( basedir, "target/site/index.html" )

// Verifies that all the files were created
assert index.exists()

// Acquires the sample HTML content
String html = index.getText()

// Verifies the footer columns exist and contain the expected data
assert html.contains( '<dt>General Info</dt>' )
assert html.contains( '<dd><a href="./acquire.html" title="Acquire">Acquire</a></dd>' )
assert html.contains( '<dd><a href="./usage.html" title="Usage">Usage</a></dd>' )

assert !html.contains( '<dt>Code</dt>' )

assert !html.contains( '<dt>Releases</dt>' )
