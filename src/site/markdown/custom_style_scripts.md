# Custom Style and Scripts

## Custom Style

The page style is minified and stored into the file located at /css/style.min.css. This file should not be overriden.

To add additional styles first create a new file in the site resources folder, for example /src/site/resources/css/custom.css. Then add the following to the site.xml file:

```xml
<custom>
   <skinConfig>
      <customStyle>./css/custom.css</customStyle>
   </skinConfig>
</custom>
```

## Custom Scripts

In a similar way, the page scripts are stored into /js/scripts.min.js, which should not be overriden.

Again, to add additional scripts first create a file in the site resources folder, for example /src/site/resources/js/custom.js. Then add the following to the site.xml file:

```xml
<custom>
   <skinConfig>
      <customScript>./js/custom.js</customScript>
   </skinConfig>
</custom>
```
