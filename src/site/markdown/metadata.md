# Metadata

The Skin includes some metadata blocks in each of the pages, allowing it to be shared and automatically identified. The information used for these blocks is contained in the POM and also configured in the [metadata elements of the site.xml][site-xml-metadata].

## General metadata

Some general metadata is added to the header of each page, creating a block like this:

```html
<!-- Metadata -->
<meta name="description" content="Documentation for the Docs Maven Skin">
<meta name="keywords" content="Maven Site, fix, HTML5">
<meta name="author" content="Bernardo Martínez Garrido" />
```

The author is taken from the list of authors in the POM, and one entry will be created for each of them.

The other data is taken from the following elements in the site.xml file:

```xml
<custom>
    <skinConfig>
        ...
        <keywords>Maven Site, fix, HTML5</keywords>
        <descriptionUrl>Documentation for the Docs Maven Skin</descriptionUrl>
        ...
    </skinConfig>
</custom>
```

If any of these elements is missing then the corresponding field won't be added.

## Social networks metadata

Each page will include a bit of data for both Facebook's [Open Graph][open-graph] and [Twitter Cards][twitter-cards].

### Facebook's Open Graph

The generated Open Graph metadata will be similar to this:

```html
<!-- Facebook Open Graph -->
<meta property="og:type" content="website"/>
<meta property="og:site_name" content="Docs Maven Skin &#x2013; Maven Site as a documentation site"/>
<meta property="og:title" content="Docs Maven Skin &#x2013; Maven Site as a documentation site"/>
<meta property="og:description" content="Documentation for the Docs Maven Skin"/>
```

This data is taken from the following elements in the site.xml file:

```xml
<custom>
    <skinConfig>
        ...
        <descriptionUrl>Documentation for the Docs Maven Skin</descriptionUrl>
        ...
    </skinConfig>
</custom>
```

Additionally, if a *canonicalLink* element is included in the site.xml configuration, containing the absolute link to the page, then a field tagged *og:url* will be added to the metadata block.

If any of these elements is missing then the corresponding field won't be added.

### Twitter Cards

The generated Twitter Card metadata will be similar to this:

```html
<!-- Twitter Card -->
<meta name="twitter:card" content="summary"/>
<meta name="twitter:site" content="@bernardomg_BMG"/>
<meta name="twitter:title" content="Docs Maven Skin &#x2013; Preparing the site.xml file"/>
<meta name="twitter:description" content="Documentation for the Docs Maven Skin"/>
```

This data is taken from the following elements in the site.xml file:

```xml
<custom>
    <skinConfig>
        ...
        <descriptionUrl>Documentation for the Docs Maven Skin</descriptionUrl>
        <twitterSite>@bernardomg_BMG</twitterSite>
        ...
    </skinConfig>
</custom>
```

If the *twitterSite* element is missing then the metadata block won't be added to the page. If any other element is missing then the corresponding field won't be added.

### Titles

The title shown in these blocks is the same one that is generated automatically for each Maven Site page, and so will change from page to page.


[site-xml-metadata]: ./site_xml.html#twitterandfacebookmetada

[open-graph]: http://ogp.me/
[twitter-cards]: https://dev.twitter.com/cards/overview
