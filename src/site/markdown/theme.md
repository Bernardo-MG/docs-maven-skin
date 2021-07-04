# Theme Customization

The theme style is taken from [Bootswatch][bootswatch]. All customization is based on the themes offered by Bootswatch.

## Changing Theme

By default the Litera theme is used. But this can be changed to any other from the current version of Bootswatch. To change you can use the `bootswatchStyle` config option in your *site.xml* file.

For example, to use Sketchy add this to your *site.xml* file:

```xml
<custom>
  <skinConfig>
    <!-- Use the sketchy style -->
    <bootswatchStyle>sketchy</bootswatchStyle>
  </skinConfig>
</custom>
```

## Dark Themes

The skins by default is prepared for light themes. To change this you need to make use of the `shine` config option.

For example, to set up the Darkly theme add this to your *site.xml* file:

```xml
<custom>
  <skinConfig>
    <!-- Use the sketchy style -->
    <bootswatchStyle>darkly</bootswatchStyle>
    <shine>dark</shine>
  </skinConfig>
</custom>
```

### Background shine

By default dark menus will be set for the primary color. This can be overriden with the `bgshine` option.

```xml
<custom>
  <skinConfig>
    <!-- Use the sketchy style -->
    <bootswatchStyle>darkly</bootswatchStyle>
    <shine>dark</shine>
    <bgshine>dark</bgshine>
  </skinConfig>
</custom>
```

[bootswatch]: https://bootswatch.com/