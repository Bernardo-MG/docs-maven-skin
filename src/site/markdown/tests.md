# Tests

The project includes various tests run with the [Maven Invoker][maven-invoker] plugin, each of them contains a example project, prepared to generate Maven Site with various configurations.

Adding a new test just requires including a new project in its own folder inside the path *src\test\resources\it*. The Invoker plugin will build all those projects and generate a report with the results.

[maven-invoker]: http://maven.apache.org/plugins/maven-invoker-plugin/
