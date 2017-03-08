#Preparing the site.xml file

For the skin to work properly, a few things have to be prepared on the site.xml file, which is known as the [Maven Site Descriptor][maven-site-descriptor].

## Skin config

The Skin requires a custom configuration element, named *skinConfig*, which will contain most of the required information.

The general structure of this element will look like the following example:

```xml
<custom>
    <skinConfig>
        <keywords></keywords>
        <descriptionUrl></descriptionUrl>
        <twitterSite></twitterSite>
        <releaseRepositories>
            <releaseRepository>
                <name></name>
                <url></url>
            </releaseRepository>
        </releaseRepositories>
        <topNav>
            <menu></menu>
        </topNav>
        <bottomNav>
            <menu></menu>
        </bottomNav>
    </skinConfig>
</custom>
```

### Configuration elements

|Element|Use|
|---|---|
|keywords|Value for the keywords HTML field|
|descriptionUrl|Description of the page, used for Open Graph and Twitter Card|
|twitterSite|The identifier (@tag) for Twitter Card|
|releaseRepositories|The various releases repositories which contain the project. For example, Maven Central|
|topNav|Menus for the top navigation menu|
|bottomNav|Additional menus for the bottom navigation menu|

#### Menus

When menus are defined in one of the options these are taken from the site.xml file. The name set in the menu node should be the name of one of the defined menus.

So for example the following menu may be set:

```xml
<custom>
    <skinConfig>
        ...
        <topNav>
            <menu>General Info</menu>
        </topNav>
        ...
    </skinConfig>
</custom>
```

Which would require the following menu to exist:

```xml
<body>
    ...
    <menu name="General Info" inherit="top">
        <item name="Acquire" href="./acquire.html" />
        <item name="Usage" href="./usage.html" />
        <item name="Changes Log" href="./changes-report.html" />
    </menu>
    ...
</body>
```

If the top navigation menu is not defined like that, all the menus will be used to generate it.

If the bottom navigation menu is not defined, it won't be generated at all.

### Facebook's Open Graph and Twitter Cards metadata

The data contained in some of the elements will be used to generate the metadata on each page. For more information about this check the [metadata section][metadata].

### Top navigation

The top navigation is the dropdown menus in the navigation bar.

### Bottom navigation

The bottom navigation are the columns containing links in the footer.


[metadata]: ./metadata.html

[maven-site-descriptor]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html