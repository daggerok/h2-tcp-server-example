# h2 tcp server
An example how to run H2 TCP Server by using Maven ang Gradle build tools

## gradle

_see [build.gradle.kts](./build.gradle.kts) and [settings.gradle.kts](./settings.gradle.kts) files_

```bash
./gradlew copy h2
# ./gradlew copy ; java -cp ./build/lib/*.jar org.h2.tools.Server -tcp -tcpAllowOthers -ifNotExists -web -webAllowOthers -baseDir ./build/
```

## maven

_see [pom.xml](./pom.xml) file_

```bash
./mvnw dependency:copy exec:exec
# ./mvnw dependency:copy ; java -cp ./target/lib/*.jar org.h2.tools.Server -tcp -tcpAllowOthers -ifNotExists -web -webAllowOthers -baseDir ./target/
```

NOTE: _This project has been based on [GitHub: daggerok/main-starter](https://github.com/daggerok/main-starter)_
