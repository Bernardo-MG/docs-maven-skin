
// The files to test are read
File index = new File( basedir, "target/site/index.html" )

// Verifies that all the files were created
assert index.exists()
