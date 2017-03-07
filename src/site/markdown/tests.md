# Tests

The project includes various tests run with the [Maven Invoker][maven-invoker] plugin, each of them contains a example project, prepared to generate Maven Site with various configurations.

Adding a new test just requires including a new project in its own folder inside the path *src\test\resources\it*. The Invoker plugin will build all those projects and generate a report with the results.

## Validations applied

Each test consists on two parts. First the site is built, and then the verify.groovy script, contained in each testing project root, is run, verifying that certain conditions are met.

Generally, at least the following is validated in each test:

* The expected HTML files are created
* The index page conforms HTML5 rules
* The expected elements are created

For testing the HTML 5 rules the [jcabi W3C validator][jcabi-w3c] is used.

The HTML elements are validated with [jsoup][jsoup] and CSS selectors.

[maven-invoker]: http://maven.apache.org/plugins/maven-invoker-plugin/

[jcabi-w3c]: http://w3c.jcabi.com/
[jsoup]: https://jsoup.org/
