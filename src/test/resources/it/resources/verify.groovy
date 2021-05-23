// This script verifies that a minimal site contains only the barebones of a site.

// Verifies that all the files were created
[
    'target/site/lib/bootstrap/dist/js/bootstrap.min.js',
    'target/site/lib/bootswatch/dist/litera/bootstrap.min.css',
    'target/site/lib/font-awesome/css/all.min.css',
    'target/site/lib/html5shiv/dist/html5shiv.min.js',
    'target/site/lib/highlight/highlight.pack.js'
].each {
    def file = new File(basedir, it)
    if (!file.exists()) {
        throw new IllegalStateException(
            "file ${file} doesn't exist"
        )
    }
}

assert true
