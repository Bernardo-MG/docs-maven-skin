# Metadata

Metadata blocks will be added to every page in the site, created mostly with information taken from the POM, but also with a bit of it configured in the [metadata elements of the site.xml][site-xml-metadata].

## Site Description Metadata

The skin always tries to add the following elements to the page head:

```html
<!-- Metadata -->
<meta name="description" content="Documentation for the Docs Maven Skin">
<meta name="keywords" content="Maven Site, fix, HTML5">
<meta name="author" content="Bernardo Martínez Garrido" />
```

One author will be added for each author in the POM, while the keywords and description are taken from the site configuration:

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

## Social Networks Metadata

If enough information is available then [Open Graph][open-graph] and [Twitter Cards][twitter-cards] elements will be added too.

### Facebook's Open Graph

The Open Graph metadata looks similar to this:

```html
<!-- Facebook Open Graph -->
<meta property="og:type" content="website"/>
<meta property="og:url" content="http://www.somewhere.com"/>
<meta property="og:site_name" content="Docs Maven Skin &#x2013; Maven Site as a documentation site"/>
<meta property="og:title" content="Docs Maven Skin &#x2013; Maven Site as a documentation site"/>
<meta property="og:description" content="Documentation for the Docs Maven Skin"/>
```

Most of this information is always available, except for the description and the URL, which should be defined in the site configuration:

```xml
<custom>
    <skinConfig>
        ...
        <descriptionUrl>Documentation for the Docs Maven Skin</descriptionUrl>
        <canonicalLink>http://www.somewhere.com</canonicalLink>
        ...
    </skinConfig>
</custom>
```

### Twitter Cards

The Twitter Card metadata looks similar to this:

```html
<!-- Twitter Card -->
<meta name="twitter:card" content="summary"/>
<meta name="twitter:creator" content="@bernardomg_BMG"/>
<meta name="twitter:title" content="Docs Maven Skin &#x2013; Preparing the site.xml file"/>
<meta name="twitter:description" content="Documentation for the Docs Maven Skin"/>
```

Again, some information should be defined in the site configuration, this time it's the description and Twitter id:

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

### Titles

The social network metadata requires a title. This will be the one generated automatically for each Maven Site page, and will change from page to page.


[site-xml-metadata]: ./custom_site_descriptor.html#metadata

[open-graph]: http://ogp.me/
[twitter-cards]: https://dev.twitter.com/cards/overview
