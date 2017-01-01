
// The files to test are read
File index = new File( basedir, "target/site/index.html" )

// Verifies that all the files were created
assert index.exists()

// Acquires the sample HTML content
String html = index.getText()

// Verifies the footer columns exist
assert html.contains( '<dt>General Info</dt>' )
assert html.contains( '<dt>Code</dt>' )
assert html.contains( '<dt>Releases</dt>' )
