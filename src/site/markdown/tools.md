# Used tools

## Maven Site Fixer

The [Maven Site Fixer][maven-site-fixer] is a project created to ease adapting the generated HTML code to modern standards, and is used heavily in the skin.

As the project is already prepared to be automatically detected by Velocity it requires no configuration. Just by adding it as a dependency it can be used in the Velocity templates.

## Basic template

A basic template, the [Docs Bootstrap Template][docs-template], is used to direct the development of the skin, serving as a template which should be transformed into the actual Maven Site.

## Libraries for the resulting HTML

[Bootstrap][bootstrap] and [Font Awesome][font_awesome] are used to ease the creation of the UI.


[maven-site-fixer]: https://github.com/Bernardo-MG/maven-site-fixer
[docs-template]: https://github.com/Bernardo-MG/docs-bootstrap-template

[bootstrap]: http://getbootstrap.com/
[font_awesome]: https://fortawesome.github.io/Font-Awesome/
