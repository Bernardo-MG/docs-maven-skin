# Code section

This is an example for a Maven Site using a code section.

This is an XML code section:

```xml
<build>
    <plugins>
        ...
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-site-plugin</artifactId>
            <dependencies>
                ...
                <dependency>
                    <!-- Docs Maven Skin -->
                    <groupId>com.wandrell.maven.skins</groupId>
                    <artifactId>docs-maven-skin</artifactId>
                    <version>${site.skin.version}</version>
                </dependency>
                ...
            </dependencies>
            ...
        </plugin>
        ...
    </plugins>
</build>
```

This is a Java code section:

```java
/**
 * Returns a greeting.
 *
 * @return a greeting
 */
public String sayHello() {
    return "Hello World!";
}
```

This is a line command:

```bash
$ mvn clean verify
```
