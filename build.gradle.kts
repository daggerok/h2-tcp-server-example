plugins {
  java
}

tasks.withType(Wrapper::class.java) {
  val gradleWrapperVersion: String by project
  gradleVersion = gradleWrapperVersion
  distributionType = Wrapper.DistributionType.BIN
}

java {
  val javaVersion = JavaVersion.VERSION_1_8
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

repositories {
  mavenCentral()
}

val lib by configurations.creating {
  extendsFrom(configurations["runtime"]) // not necessary
}

dependencies {
  val h2Version: String by project
  lib("com.h2database:h2:$h2Version")
}

tasks {
  create("copy", Copy::class.java) {
    from(configurations["lib"])
    into("${project.buildDir}/lib")
  }

  create("h2", JavaExec::class.java) {
    dependsOn("copy")
    classpath = project.fileTree("${project.buildDir}/lib")
    main = "org.h2.tools.Server"
    setArgsString("-tcp -tcpAllowOthers -ifNotExists -web -webAllowOthers -baseDir ${project.buildDir}")
  }
}

defaultTasks("copy", "h2")
