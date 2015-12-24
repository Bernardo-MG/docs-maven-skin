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
        <interpreters>
            <interpreter></interpreter>
        </interpreters>
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
|interpreters|Java versions which the project supports|
|releaseRepositories|Information of the various releases repositories which contain the project, such as for example Maven Central|
|topNav|Menus for the top navigation menu|
|bottomNav|Additional menus for the bottom navigation|

### Facebook's Open Graph and Twitter Cards metadata

The data contained in some of the elements will be used to generate the metadata on each page. For more information about this check the [metadata section][metadata].

### Bottom navigation

While it is possible to add menus to the bottom navigation, there should be always space for two additional menus which the skin will always add: the code and releases repos menus.

The code menu contains the information about the code services being used, such as continuous integration or code repository. This information is taken from the POM.

The releases menu contains the list of releases repositories defined on the *releaseRepositories* element.

#### Code column

The code column will add a link for the SCM, CI and issues services being used. The data for these is taken automatically from the POM.

#### Release repositories column

For each entry in the *releaseRepositories* node a repository will be added to the footer.

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

#### Additional columns

Any additional menu defined in the menus section and added to the *bottomNav* node will be appended at the start of the bottom columns.

For example, the general information column included in this page is done by using the following configuration:

```xml
<custom>
    <skinConfig>
        ...
        <bottomNav>
            <menu>General Info</menu>
        </bottomNav>
        ...
    </skinConfig>
</custom>
```

And the following menu:

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

#### Interpreters list

The Java interpreters node will be used for creating the list of supporter interpreters in the footer.

For example, using following list:

```xml
<custom>
    <skinConfig>
        ...
        <interpreters>
            <interpreter>JDK 7</interpreter>
            <interpreter>JDK 8</interpreter>
            <interpreter>OpenJDK 7</interpreter>
        </interpreters>
        ...
    </skinConfig>
</custom>
```

This will create list in the footer with an item for each of the three interpreters.


[metadata]: ./metadata.html

[maven-site-descriptor]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html