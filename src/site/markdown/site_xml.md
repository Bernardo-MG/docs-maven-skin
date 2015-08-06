#Preparing the site.xml file

For the skin to work properly, a few things have to be prepared on the site.xml file.

## Skin config

First of all, a skin configuration element, called skinConfig, should be added to the custom one.

The general structure of it will look like the following example:

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
|bottomNav|Menus for the bottom navigation|

### Bottom navigation

While it is possible to add menus to the bottom navigation, there should be always space for two additional menus which the skin will always add: the code and releases repos menus.

The code menu contains the information about the code services being used, such as continuous integration or code repository. This information is taken from the POM.

The releases menu contains the list of releases repositories defined on the releaseRepositories element.