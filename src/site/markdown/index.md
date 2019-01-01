# Maven Site as a documentation site

One of the less know features of Maven is generating a site for your project. With documentation, general information and reports. Sadly it depends on old Doxia plugins, and requires from Maven skins if you want your site to be minimally good lookin. And building a Maven Skin can be a pain.

## Why Using This Library?

Because you want a modern and simple skin for your Maven site. Because you want to include documentation which can be generated along your Maven project.

This isn't the only Maven Skin in existence, but most of them are outdated, many are no longer usable due to breaking changes in the required plugins, and most are no longer maintained.

So I offer you a minimalist Skin, which follows the HTML5 standard and makes use of well know libraries to build the views.

## Features

The main features offered by the skin are:

- Minimalist and reactive look
- HTML5
- [Bootstrap 3][bootstrap]
- [Font Awesome][font_awesome] icons
- [highlight.js][highlight] for syntax highlighting
- Prepared for [Facebook's Open Graph][open-graph] and [Twitter Cards][twitter-cards]

## Template

The skin has been adapted from the static template [Docs Bootstrap Template][docs-template], which will be the visual reference to be followed by this project.

## Examples

This site you are reading right now is an example of the skin, as it was created by using the Maven Site plugin and the Docs Maven Skin.

## Acknowledgement

The project started as a fork of the [Reflow Maven Skin][reflow], but it quickly became its own thing. Still, it owes much to that project.


[bootstrap]: http://getbootstrap.com/
[docs-template]: https://github.com/Bernardo-MG/docs-bootstrap-template
[font_awesome]: https://fortawesome.github.io/Font-Awesome/
[highlight]: https://highlightjs.org/
[reflow]: http://andriusvelykis.github.io/reflow-maven-skin/
[open-graph]: http://ogp.me/
[twitter-cards]: https://dev.twitter.com/cards/overview
