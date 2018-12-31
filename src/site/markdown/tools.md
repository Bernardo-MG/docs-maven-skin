# Used tools

## Maven Site Fixer

The [Maven Site Fixer][maven-site-fixer] is a set of Velocity tools created to ease adapting the generated HTML code to modern standards, and is used heavily by the skin.

As the Maven Site Fixer is set to be autodetected, a feature of Velocity tools projects, it requires no configuration. Just by adding it as a dependency it can be used in the Velocity templates.

## Frontend Libraries

These are CSS and Javascript libraries used to build the UI looks.

* [Bootstrap][bootstrap], for the UI structure
* [Font Awesome][font_awesome], for the icons
* [JQuery][jquery], required by Bootstrap, used for editing the DOM
* [highlight.js][highlight], for the code blocks

To this a few custom Javascript files have been added.

### Loading Libraries

Most frontend dependencies are handled through npm, and defined inside the package.json file. Only highligh.js is included as a static library, because it needs additional configuration.

All these are libraries include minified versions, which are copied into the project, ready to be used.

### Additional Libraries

A few custom javascript utilities are contained in the project. These will be minified when building the project, and stored into the scripts.min.js file.

## Basic Template

A basic template, the [Docs Bootstrap Template][docs-template], is used to direct the development of the skin, serving as a template which should be transformed into the actual Maven Site.


[maven-site-fixer]: https://github.com/Bernardo-MG/maven-site-fixer
[docs-template]: https://github.com/Bernardo-MG/docs-bootstrap-template

[bootstrap]: http://getbootstrap.com/
[font_awesome]: https://fortawesome.github.io/Font-Awesome/
[highlight]: https://highlightjs.org/
[jquery]: https://jquery.com/
