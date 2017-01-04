# library-maven-archetype-example

This is a base project created with the [Library Maven Archetype][library-archetype], prepared to ease the development of new libraries.

Note that while it is meant to be a working project from the beginning, meaning that it compiles, runs the tests and creates the docs, it is mostly composed of placeholder classes which should be swapped with actual content.

## Where should I start customizing the project?

First of all, check the [Library Maven Archetype][library-archetype] documentation, and then edit the readme file and the Maven site descriptions about the project.

After that, of course, the classes and tests included should be replaced with actual code, which also means adding dependencies and changing profiles and plugins as needed on the POM.

## Some external requirements

While the project can be used just by itself, it won't take full advantage of most of the configuration until it is integrated with a few services:

- Version control system, Github by default.
- Continuous integration, Travis CI by default.
- Releases repository, Bintray by default.
- Test artifacts repository, Sonatype OSS by default.
- Documentation repository, a FTP by default.

[library-archetype]: https://github.com/Bernardo-MG/library-maven-archetype