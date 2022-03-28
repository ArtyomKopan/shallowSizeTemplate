import java.nio.file.Paths

val kotlinVersion: String by project
val arrowMetaVersion: String by project

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")
    compileOnly("io.arrow-kt:arrow-meta:$arrowMetaVersion")
}

tasks.jar {
    archiveBaseName.set("shallow-size-plugin")
    from(
        sourceSets.main.get().compileClasspath.find {
            it.absolutePath.contains(Paths.get("arrow-kt", "arrow-meta").toString())
        }?.let { zipTree(it) }
    )
}