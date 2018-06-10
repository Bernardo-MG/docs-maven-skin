# highlight.js

[highligh.js][highlight] is being used for the code sections. As it is a big library it may require customization, and these are some tips to achieve that.

## Overriding Initialization

The library is loaded through the initializeHighlight.js file, located at js/initializeHighlight.js in the site. This can't be changed, but Maven Site allows overriding files.

To do this just add your own file at src/site/resources/js/initializeHighlight.js in your project. That is, add a new initializeHighlight.js for your Maven Site. This will replace the default file, as the project site resources will take the place of the default ones.

[highlight]: https://highlightjs.org/
