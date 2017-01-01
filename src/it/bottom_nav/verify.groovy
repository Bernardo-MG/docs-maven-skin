
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

assert html.contains( '<dt>Code</dt>' )
assert html.contains( '<dd><a href="https://github.com/Bernardo-MG/docs-maven-skin" class="link-noted">SCM' )
assert html.contains( '<dd><a href="https://travis-ci.org/Bernardo-MG/docs-maven-skin" class="link-noted">CI' )
assert html.contains( '<a href="https://www.github.com/bernardo-mg/docs-maven-skin/issues" class="link-noted">Issues' )

assert html.contains( '<dt>Releases</dt>' )
assert html.contains( '<dd><a href="https://bintray.com/bernardo-mg/maven/docs-maven-skin/view">Bintray</a></dd>' )
assert html.contains( '<dd><a href="http://mvnrepository.com/artifact/com.wandrell.maven.skins/docs-maven-skin">Maven Central</a></dd>' )
