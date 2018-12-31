# highlight.js

[highligh.js][highlight] is being used for the code sections, but as it is a big library it may require customization.

## Overriding Configuration

The site will load the library located at /lib/highlight/highlight.pack.js.

To override the default file place your own highlight.pack.js file at src/site/resources/lib/highlight/highlight.pack.js, along any resources it may need.

## Overriding Initialisation

The library is loaded through the file located at js/initializeHighlight.js. 

To override this file add your own at src/site/resources/js/initializeHighlight.js inside your project.

This new initialization file would look similar to this, but adapted to your needs:

```javascript
$(document).ready(function() {

   // Uses the default initialization
   hljs.initHighlightingOnLoad();

});
```

[highlight]: https://highlightjs.org/
