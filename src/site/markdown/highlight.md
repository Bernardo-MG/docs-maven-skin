# highlight.js

[highligh.js][highlight] is being used for the code sections. As it is a big library it may require customization, and these are some tips to achieve that.

## Overriding Initialization

The library is loaded through the file js/initializeHighlight.js. This can't be changed, but the file may be overriden.

To do this just add your own file at src/site/resources/js/initializeHighlight.js. This will replace the default file.

[highlight]: https://highlightjs.org/
