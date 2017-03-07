# Maven Site as a documentation site

Maven handles not only dependencies, but also several project-related resources, such as reports or general project information, which can be integrated into a single web page: the Maven Site.

This small customizable webpage can be created automatically by Maven, and is meant to be a centralized reference for any Maven project, but sadly is not as easy and simple to use as it is meant to, due to it's dependency on old Doxia plugins and the small range of Maven Site Skins available.

## Why this library?

Using the Maven Site as a documentation site sounds attractive, but is rarely done due to several problems, the first of them all being that most of the available skins are outdated and ugly.

Even the best ones suffer from not adapting to current standards, or using obsolete libraries, as it happens to the [Reflow Maven Skin][reflow], the project which served as the foundation for this one. It makes use of an old version of Bootstrap and various design choices which are no longer recommended, and above all it had a bunch of additional and not at all needed complexities.

A modern docs site is meant to be easy to use and, if needed, adapt. It should follow the HTML5 rules, and also make use of accessible libraries, such as Bootstrap and Font Awesome, for the UI, meaning that anybody can easily know how to work with it.

An example of this is the project which was adapted into this skin, the [Docs Bootstrap Template][docs_template], a minimalistic and reactive template for documentation sites.

## Features

The main features offered by the skin are:

- Minimalist and reactive look
- HTML5
- [Bootstrap 3][bootstrap]
- [Font Awesome][font_awesome] icons
- [highlight.js][highlight] for syntax highlighting
- Prepared for [Facebook's Open Graph][open-graph] and [Twitter Cards][twitter-cards]

## Examples

This site is already an example of the skin, as it was created by using the Maven Site plugin and the Docs Maven Skin.

[bootstrap]: http://getbootstrap.com/
[docs_template]: https://github.com/Bernardo-MG/docs-bootstrap-template
[font_awesome]: https://fortawesome.github.io/Font-Awesome/
[highlight]: https://highlightjs.org/
[reflow]: http://andriusvelykis.github.io/reflow-maven-skin/
[open-graph]: http://ogp.me/
[twitter-cards]: https://dev.twitter.com/cards/overview
