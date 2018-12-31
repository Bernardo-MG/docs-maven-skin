# Custom Style and Scripts

## Custom Style

The page style is minified and stored into the file located at /css/style.min.css. This file should not be overriden.

To add additional styles first create a new file in the site resources folder, in this example /src/site/resources/css/custom.css, then add the following to the site.xml file:

```xml
<custom>
   <skinConfig>
      <customStyle>./css/custom.css</customStyle>
   </skinConfig>
</custom>
```

## Custom Scripts

Similarly the page scripts are stored into /js/scripts.min.js, and this file should not be touched.

To add additional scripts first create a file in the site resources folder, like /src/site/resources/js/custom.js, then add the following to the site.xml file:

```xml
<custom>
   <skinConfig>
      <customScript>./js/custom.js</customScript>
   </skinConfig>
</custom>
```
