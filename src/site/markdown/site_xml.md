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

### Facebook's Open Graph and Twitter Cards metadata

The data contained in some of the elements will be used to generate the metadata on each page. For more information about this check the [metadata section][metadata].

### Top navigation

The top navigation is the dropdown menus in the navigation bar.

### Bottom navigation

The bottom navigation are the columns containing links in the footer.

### Bottom navigation auto-generated columns

Two additional menus will be generated from the project and repositories information, the code and releases columns. These columns will be added after the ones defined by the user.

#### Code column

The code column will add a link for the SCM, CI and issues services being used. The data for these is taken automatically from the POM.

#### Releases column

For each entry in the *releaseRepositories* node a repository link will be added to the column.

Each of them should be a entry like the following:

```xml
<custom>
    <skinConfig>
        ...
        <releaseRepository>
            <name>Maven Central</name>
            <url>http://mvnrepository.com/artifact/com.wandrell.maven.skins/docs-maven-skin</url>
        </releaseRepository>
        ...
    </skinConfig>
</custom>
```

Which will create a link in the repositories column with the *name* as the text and pointing to the *url*.

As Maven applies variables substitution on the site.xml file this information may be defined in the properties section of the POM, and be used like this:

```xml
<custom>
    <skinConfig>
        ...
        <releaseRepository>
            <name>Maven Central</name>
            <url>${mavenURL}</url>
        </releaseRepository>
        ...
    </skinConfig>
</custom>
```

In this case the URL will be read from the *mavenURL* property:

```xml
<properties>
    ...
    <mavenURL>http://mvnrepository.com/artifact/com.wandrell.maven.skins/docs-maven-skin</mavenURL>
    ...
</properties>
```


[metadata]: ./metadata.html

[maven-site-descriptor]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html