plugins {
    java
    kotlin("jvm") version "1.8.10"
    id("org.jetbrains.dokka") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"

    `maven-publish`
}

group = "net.projecttl"
version = "4.5.0"

allprojects {
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.dokka")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    repositories {
        mavenCentral()
    }
}

subprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        maven("https://papermc.io/repo/repository/maven-public/")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") {
            name = "sonatype-oss-snapshots"
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        compileOnly("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
        if (this@subprojects.name != "InventoryGUI-api") {
            dependencies {
                implementation(project(":InventoryGUI-api"))
            }
        }
    }
}
