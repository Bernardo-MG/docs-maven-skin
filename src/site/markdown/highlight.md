# highlight.js

[highligh.js][highlight] is being used for the code sections, but as it is a big library it may require customization.

## Overriding Initialisation

The library is loaded through the initializeHighlight.js file, located at js/initializeHighlight.js in the site. This can't be changed, but Maven Site allows overriding files.

To do this just add your own file at src/site/resources/js/initializeHighlight.js in your project. That way your file will take the place of the default one.

This new initialization file would look similar to this, but adapted to your needs:

```javascript
$(document).ready(function() {

   // Uses the default initialization
   hljs.initHighlightingOnLoad();

});
```

[highlight]: https://highlightjs.org/
