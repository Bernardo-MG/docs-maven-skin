# Site Descriptor Support

The following [site descriptor][site_descriptor] options are supported.

## Title

```
<project name="Overriden Title">

</project>
```

Will be used to override the project name for the site.

## Links

```
<project>

   <body>
      <links>
         <item name="Apache" href="http://www.apache.org" />
         <item name="Maven" href="https://maven.apache.org" />
      </links>
   </body>

</project>
```

These will be added between the icons menu and the dropdown menu.

## Head Content

```
<project>

   <body>
      <head><![CDATA[<meta name="test" content="value"/>]]></head>
   </body>

</project>
```

It will be added after the metadata and styles.

## Footer Content

```
<project>

   <body>
      <footer><![CDATA[Custom footer content]]></footer>
   </body>

</project>
```

It will be added after the default footer content.

## Google Analytics

```
<project>

   <googleAnalyticsAccountId>accountId</googleAnalyticsAccountId>

</project>
```

This id will be used to set up [Google Analytics][google_analytics] tracking.

[site_descriptor]: https://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html

[google_analytics]: https://analytics.google.com/analytics/web/
