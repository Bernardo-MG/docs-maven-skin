# Usage

[Once the dependencies have been set][acquire] register the sking into the site.xml file:

```xml
<skin>
   <groupId>com.bernardomg.maven.skins</groupId>
   <artifactId>docs-maven-skin</artifactId>
   <version>${project.version}</version>
</skin>
```

## Sample site.xml

The sking supports several standard descriptors, along a bunch of exclusive options.

For more details check the [suported site descriptors][site_descriptor] and the [custom site descriptors][custom_site_descriptor].

The following shows a sample site.xml file useful as a base for most sites:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/DECORATION/1.8.0"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/DECORATION/1.8.0 http://maven.apache.org/xsd/decoration-1.8.0.xsd">

   <skin>
      <groupId>com.bernardomg.maven.skins</groupId>
      <artifactId>docs-maven-skin</artifactId>
   <version>${symbol_dollar}{site.skin.version}</version>
   </skin>

   <custom>
      <skinConfig>
         <keywords>Maven Site, fix, HTML5</keywords>
         <descriptionUrl>Check the documentation for the Docs Maven Skin</descriptionUrl>
         <twitterSite>@bmg</twitterSite>
         <topNav>
            <menu>Documentation</menu>
            <menu>Info and reports</menu>
         </topNav>
         <bottomNav>
            <menu>General Info</menu>
            <menu>Code</menu>
            <menu>Releases</menu>
         </bottomNav>
         <iconNav>
            <menu>Icons</menu>
         </iconNav>
      </skinConfig>
   </custom>

   <body>
      <menu name="General Info" inherit="top">
         <item name="Acquire" href="./acquire.html" />
         <item name="Usage" href="./usage.html" />
         <item name="Changes Log" href="./changes-report.html" />
      </menu>
      <menu name="Documentation" inherit="bottom">
         <item name="Acquire" href="./acquire.html" />
         <item name="Usage" href="./usage.html" />
         <item name="Tests" href="./tests.html" />
      </menu>
      <menu name="Info and reports" inherit="bottom">
         <item name="Info" href="./info.html" />
         <item name="Reports" href="./reports.html" />
         <item name="JavaDocs" href="./apidocs/" />
      </menu>
      <menu name="Code" inherit="bottom">
         <item name="SCM" href="${project.scm.url}">
            <description>GitHub</description>
         </item>
         <item name="CI" href="${project.ciManagement.url}">
            <description>${project.ciManagement.system}</description>
         </item>
         <item name="Issues" href="${project.issueManagement.url}">
            <description>${project.issueManagement.system}</description>
         </item>
      </menu>
      <menu name="Releases" inherit="bottom">
         <item name="Bintray" href="${bintrayURL}" />
         <item name="Maven Central" href="${mavenURL}" />
      </menu>
      <menu name="Icons" inherit="bottom">
         <item name="Github" img="github" href="${project.scm.url}" />
      </menu>
   </body>
</project>
```

[acquire]: ./acquire.html
[site_descriptor]: ./site_descriptor.html
[custom_site_descriptor]: ./custom_site_descriptor.html
