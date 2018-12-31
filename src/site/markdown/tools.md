# Tools Used

## Maven Site Fixer

The [Maven Site Fixer][maven-site-fixer] is a collection of Velocity tools created to transform the HTML code generated for the Maven sites into modern standards.

As the Maven Site Fixer is set to be autodetected, a feature of Velocity tools projects, it requires no configuration. Just by adding it as a dependency it can be used in any Velocity template.

## Frontend Libraries

These are the CSS and Javascript libraries used to build the views:

* [Bootstrap][bootstrap], for the UI structure
* [Font Awesome][font_awesome], for the icons
* [JQuery][jquery], required by Bootstrap, used for editing the DOM
* [highlight.js][highlight], for the code blocks

These dependencies are handled through npm, and the minified version of each is added into the packaged skin.

Only highlight.js is included as a static dependency, as it requires additional configuration.

### Additional Libraries

Along these libraries few custom javascript utilities are contained inside the project. They will be minified when building the project, and stored into the scripts.min.js file.

Any javascript file added to src/main/resources/js/utils will be included into this file.

## Basic Template

The [Docs Bootstrap Template][docs-template] is used to direct the development of the skin, serving as a reference template.


[maven-site-fixer]: https://github.com/Bernardo-MG/maven-site-fixer
[docs-template]: https://github.com/Bernardo-MG/docs-bootstrap-template

[bootstrap]: http://getbootstrap.com/
[font_awesome]: https://fortawesome.github.io/Font-Awesome/
[highlight]: https://highlightjs.org/
[jquery]: https://jquery.com/
