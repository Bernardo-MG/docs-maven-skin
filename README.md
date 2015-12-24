# Docs Maven Skin

A minimalist Bootstrap-based HTML5 skin for Maven Site, which will help to use it as a documentation site.

While it can be used by itself, just remember to check the documentation to find out how to set it up. New projects may as well make use of the [Library Maven Archetype][library-archetype] which, among other features, makes use of this skin.

The skin has been adapted from the static template [Docs Bootstrap Template][docs-template], which will be the visual reference to be followed by this project.

[![Maven Central](https://img.shields.io/maven-central/v/com.wandrell.maven.skins/docs-maven-skin.svg)][maven-repo]
[![Bintray](https://api.bintray.com/packages/bernardo-mg/maven/docs-maven-skin/images/download.svg)][bintray-repo]

[![Release docs](https://img.shields.io/badge/docs-release-blue.svg)][site-release]
[![Development docs](https://img.shields.io/badge/docs-develop-blue.svg)][site-develop]

## Feature

- Minimalist and reactive look
- HTML5
- [Bootstrap 3][bootstrap]
- [Font Awesome][font_awesome] icons
- Prepared for [Facebook's Open Graph][open-graph] and [Twitter Cards][twitter-cards]

## Demo

To check how the skin looks take a look at the documentation, linked below this section, which is a Maven Site making use of the skin.

## Documentation

Documentation is always generated for the latest release, kept in the 'master' branch:

- The [latest release documentation page][site-release].
- The [the latest release Javadoc site][javadoc-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [the latest snapshot documentation page][site-develop].
- The [the latest snapshot Javadoc site][javadoc-develop].

The documentation site sources come along the source code (as it is a Maven site), so it is always possible to generate them using the following Maven command:

```
$ mvn verify site
```

The verify phase is required, as otherwise some of the reports won't be created.

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

[bintray-repo]: https://bintray.com/bernardo-mg/maven/docs-maven-skin/view
[maven-repo]: http://mvnrepository.com/artifact/com.wandrell.maven.skins/docs-maven-skin
[issues]: https://github.com/Bernardo-MG/docs-maven-skin/issues
[javadoc-develop]: http://docs.wandrell.com/development/maven/docs-maven-skin/apidocs
[javadoc-release]: http://docs.wandrell.com/maven/docs-maven-skin/apidocs
[license]: http://www.opensource.org/licenses/mit-license.php
[scm]: https://github.com/Bernardo-MG/docs-maven-skin
[site-develop]: http://docs.wandrell.com/development/maven/docs-maven-skin
[site-release]: http://docs.wandrell.com/maven/docs-maven-skin

[library-archetype]: https://github.com/bernardo-mg/library-maven-archetype
[docs-template]: https://github.com/Bernardo-MG/docs-bootstrap-template
[bootstrap]: http://getbootstrap.com/
[font_awesome]: https://fortawesome.github.io/Font-Awesome/
[open-graph]: http://ogp.me/
[twitter-cards]: https://dev.twitter.com/cards/overview
