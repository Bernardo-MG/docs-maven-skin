# Custom Site Descriptors

Most of the common [site descriptors][site_descriptors] are supported, along a few custom options. Knowing these will allow taking full advantage of the skin.

## Skin Config

All the descriptors specific for the skin are stored inside the *skinConfig* element, which has a structure similar to:

```xml
<custom>
   <skinConfig>
      <keywords></keywords>
      <descriptionUrl></descriptionUrl>
      <twitterSite></twitterSite>
      <topNav>
         <menu></menu>
      </topNav>
      <bottomNav>
         <menu></menu>
      </bottomNav>
      <iconNav>
         <menu></menu>
      </iconNav>
      <customScript></customScript>
      <customStyle></customStyle>
   </skinConfig>
</custom>
```

These descriptors are option, and the skin will adapt to having or missing any of them.

### Menus

|Options|Usage|
|---|---|
|topNav|Dropdown navigation bar at the top of the page|
|iconNav|Icons bar at the top of the page|
|bottomNav|Navigation bar with links at the bottom of the page|

Each expects a collection of menus, which are references to the ones defined in the site.xml file.

For example the following menu can be used for the top navigation:

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

The skin will create a dropdown meny for each menu defined in topNav, while the ones in bottomNav will become a column with links.

#### Icons

The iconNav option does not work like the others, as it will be used to render a list of icons, using Font Awesome to pick them.

For this to work you just need to add an image to the menu item:

```xml
<body>
   ...
   <menu name="Icons" inherit="bottom">
      <item name="Github" img="github" href="${project.scm.url}" />
   </menu>
   ...
</body>
```

This image should be an existing Font Awesome icon, without the fa- prefix, as this will be added automatically. In this case the icon picked will be fa-github.

#### Descriptions for the Bottom Nav

The bottom navigation menu allows giving a description for each link. These will be added as an underscript next to the link name.

```xml
<body>
   ...
   <menu name="Code" inherit="bottom">
      <item name="SCM" href="${project.scm.url}">
         <description>GitHub</description>
      </item>
   </menu>
   ...
</body>
```

### Custom Scripts and Style

These options are detailed in the [Custom Style and Scripts][custom-style-scripts] page.

### Metadata

|Options|Usage|
|---|---|
|keywords|Value for the keywords HTML field|
|descriptionUrl|Description of the page, used for Open Graph and Twitter Card|
|twitterSite|The identifier (@tag) for Twitter Card|

The data contained in these elements will be used to generate the page's metadata. For more information about this check the [metadata section][metadata].

[custom-style-scripts]: ./custom_style_scripts.html
[metadata]: ./metadata.html

[site_descriptors]: ./site_descriptor.html