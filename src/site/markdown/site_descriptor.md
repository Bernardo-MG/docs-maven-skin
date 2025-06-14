# Site Descriptor Support

The following [site descriptor][site_descriptor] options are supported.

## Title

Will be used to override the project name for the site.

```xml
<project name="Overriden Title">

</project>
```

## Links

These will be added between the icons menu and the dropdown menu.

```xml
<project>

   <body>
      <links>
         <item name="Apache" href="http://www.apache.org" />
         <item name="Maven" href="https://maven.apache.org" />
      </links>
   </body>

</project>
```

## Head Content

It will be added after the metadata and styles.

```xml
<project>

   <body>
      <head><![CDATA[<meta name="test" content="value"/>]]></head>
   </body>

</project>
```

## Footer Content

It will be added after the default footer content.

```xml
<project>

   <body>
      <footer><![CDATA[Custom footer content]]></footer>
   </body>

</project>
```

## Disable Publish Date

By default the page will show the site creation date next to the version. This can be disabled, hiding the date:

```xml
<project>

   <publishDate position="none" />

</project>
```

## Doxia Edition Button

This will set the URL for the Doxia edition button.

```xml
<project>

   <edit>${project.scm.url}</edit>

</project>
```

[site_descriptor]: https://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html
