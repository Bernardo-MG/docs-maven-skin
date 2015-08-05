# Docs Maven Skin

A Bootstrap-based HTML5 skin for Maven Site, meant to help using it as a documentation site for it's project.

It has been created using the [Reflow Maven skin][reflow] as the basis and adapting the [Docs Bootstrap Template][docs-template].

[![Maven Central](https://img.shields.io/maven-central/v/com.wandrell/docs-maven-skin.svg)][maven-repo]
[![Bintray](https://api.bintray.com/packages/bernardo-mg/maven/docs-maven-skin/images/download.svg)][bintray-repo]

[![Release docs](https://img.shields.io/badge/docs-release-blue.svg)][site-release]
[![Development docs](https://img.shields.io/badge/docs-develop-blue.svg)][site-develop]

## Documentation

Currently there is no documentation for the project.

## Usage

The application is coded in Velocity Template Language, using Maven to manage the project.

### Prerequisites

This project requires a Maven-based project, with Maven Site enabled.

All other dependencies are handled through Maven, and noted in the included POM file.

### Installing

The recommended way to install the project is by setting up your preferred dependencies manager. To get the configuration information for this check the [Bintray repository][bintray-repo], or the [Maven Central Repository][maven-repo].

If for some reason manual installation is necessary, just use the following Maven command:

```
$ mvn install
```

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues management

Issues are managed at the GitHub [project issues tracker][issues], where any Github user may report bugs or ask for new features.

### Getting the code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License

The project has been released under the [MIT License][license].

[reflow]: http://andriusvelykis.github.io/reflow-maven-skin/
[docs-template]: https://github.com/Bernardo-MG/docs-bootstrap-template
[bintray-repo]: https://bintray.com/bernardo-mg/maven/docs-maven-skin/view
[maven-repo]: http://mvnrepository.com/artifact/com.wandrell.maven/docs-maven-skin
[issues]: https://github.com/Bernardo-MG/docs-maven-skin/issues
[license]: http://www.opensource.org/licenses/mit-license.php
[scm]: https://github.com/Bernardo-MG/docs-maven-skin
