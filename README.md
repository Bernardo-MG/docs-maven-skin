# Docs Maven Skin

A minimalist and responsive Bootstrap-based HTML5 skin for Maven Site, which will help to create documentation sites with Maven.

It is easy to use, just remember to check the included docs (generated with mvn verify site) to find out how to set it up, and also to find out how the skin looks in an actual Maven Site. New projects may as well make use of the [Library Maven Archetype][library-archetype] which, among other features, takes advantage of this skin and shows how to set it up.

The skin has been adapted from the static template [Docs Bootstrap Template][docs-template], which will be the visual reference to be followed by this project.

## Maven Site version support

Due to changes in the Maven Site plugin, the skin doesn't work with all versions of the plugin. Check the table to know which version of the skin is compatible.

| Maven site version | Skin version  |
|--------------------|---------------|
| 3.20.x onwards     | 2.4.0 onwards |
| 3.6.x up to 3.12.x | 2.3.x         |
| Before 3.6.x       | 1.1.x         |

[![Maven Central](https://img.shields.io/maven-central/v/com.bernardomg.maven.skins/docs-maven-skin.svg)][maven-repo]

## Features

- Minimalist and reactive look
- HTML5
- [Bootstrap 5][bootstrap]
- [Font Awesome][font_awesome] icons
- [highlight.js][highlight] for syntax highlighting
- Prepared for [Facebook's Open Graph][open-graph] and [Twitter Cards][twitter-cards]

## Demo

The project documentation makes use of the skin, it is always built with the latest release available. You can check the links just below this section.

## Documentation

Documentation can  be generated with the following Maven command:

```
mvn verify site
```

The verify phase is required, as otherwise some of the reports won't be created.

## Acknowledgement

The project started as a fork of the [Reflow Maven Skin][reflow-skin], but it quickly became its own thing. Still, it owes much to that project.

## Usage

As any Maven Skin it is handled through the Maven Plugin. Check the docs for more concrete information.

### Prerequisites

As a Maven Skin, the project requirements are very specific:

- Maven
- Maven Site plugin (>=3.21.0)
- Maven Site enabled

### Installing

The recommended way to install the project is by setting up your preferred dependencies manager. To get the configuration information for this check the [Maven Central Repository][maven-repo].

If for some reason manual installation is necessary, use the usual Maven installation command:

```
mvn install
```

### Reducing the Dependency Scope

There is no need to add the skin as a dependency for the full project. Just add it to the Maven site plugin:

```xml
<build>
    <plugins>
        ...
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-site-plugin</artifactId>
            <dependencies>
                ...
                <dependency>
                    <!-- Docs Maven Skin -->
                    <groupId>com.bernardomg.maven.skins</groupId>
                    <artifactId>docs-maven-skin</artifactId>
                    <version>${site.skin.version}</version>
                </dependency>
                ...
            </dependencies>
            ...
        </plugin>
        ...
    </plugins>
</build>
```

### Setting Up the Skin

Register the skin into the site.xml file:

```xml
<skin>
    <groupId>com.bernardomg.maven.skins</groupId>
    <artifactId>docs-maven-skin</artifactId>
    <version>[current version]</version>
</skin>
```

Afterwards the skin will be used when generating the site.

More detailed information can be found in the documentation. Including information for changing the theme.

### Running Tests

Integration tests are included in the project to verify various configurations. These can be run by using the usual Maven command:

```
mvn verify
```

They are run by using the [Maven Invoker Plugin][maven-invoker], and the configurations are included in the 'src/it' folder.

Pay attention that the results from generating these tests are copied to the generated Maven Site by the Maven Resources Plugin.

If using Eclipse the tests may not run, due to an incompatibility with the invoker. It is recommender running the tests through command line.

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues Management

Issues are managed at the GitHub [project issues tracker][issues], where any GitHub user may report bugs or ask for new features.

### Getting the Code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License

The project has been released under the [MIT License][license].

[reflow-skin]: https://github.com/andriusvelykis/reflow-maven-skin
[maven-repo]: http://mvnrepository.com/artifact/com.bernardomg.maven.skins/docs-maven-skin
[issues]: https://github.com/Bernardo-MG/docs-maven-skin/issues
[license]: http://www.opensource.org/licenses/mit-license.php
[scm]: https://github.com/Bernardo-MG/docs-maven-skin

[maven-invoker]: http://maven.apache.org/plugins/maven-invoker-plugin/

[library-archetype]: https://github.com/bernardo-mg/library-maven-archetype
[docs-template]: https://github.com/Bernardo-MG/docs-bootstrap-template
[bootstrap]: http://getbootstrap.com/
[font_awesome]: https://fortawesome.github.io/Font-Awesome/
[highlight]: https://highlightjs.org/
[open-graph]: http://ogp.me/
[twitter-cards]: https://dev.twitter.com/cards/overview
