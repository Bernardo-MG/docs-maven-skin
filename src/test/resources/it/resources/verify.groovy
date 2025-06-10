// This script verifies that a minimal site contains only the barebones of a site.

// Verifies that all the files were copied
def requiredFiles = [
    'target/site/lib/popperjs/core/dist/umd/popper.min.js',
    'target/site/lib/bootstrap/dist/js/bootstrap.min.js',
    'target/site/lib/bootswatch/dist/litera/bootstrap.min.css',
    'target/site/lib/font-awesome/css/all.min.css',
    'target/site/lib/highlight/highlight.min.js'
]

// Collect missing files
def missingFiles = requiredFiles.findAll { !new File(basedir, it).exists() }

// Fail if any are missing
if (!missingFiles.isEmpty()) {
    throw new IllegalStateException("Missing files: ${missingFiles.join(', ')}")
}

assert true