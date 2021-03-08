# Bootswatch

The style is taken from [Bootswatch][bootswatch].

## Overriding Style

By default the Litera style is used, but this can be changed to any other from the current version of Bootswatch. To utilize one of the different styles provided by [Bootswatch][bootswatch], you can specify a `bootswatchStyle` config option in your *site.xml* file.

For example, in your *site.xml* file:

```xml
<custom>
  <skinConfig>
    <!-- Use the sketchy style -->
    <bootswatchStyle>sketchy</bootswatchStyle>
  </skinConfig>
</custom>
```

[bootswatch]: https://bootswatch.com/