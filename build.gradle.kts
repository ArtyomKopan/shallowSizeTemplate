import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

val jvmTargetVersion: String by project

plugins {
    kotlin("jvm")
    id("io.gitlab.arturbosch.detekt") version "1.19.0"
    java
}

group = "spbu.kotlin.class.shallowSize"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.19.0")
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(kotlin("test"))
}


allprojects {
    apply {
        plugin("kotlin")
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
    }

    tasks.withType<KotlinJvmCompile> {
        kotlinOptions {
            jvmTarget = jvmTargetVersion
            languageVersion = "1.5"
            apiVersion = "1.5"
        }
    }
}
