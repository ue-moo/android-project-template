pluginManagement {
    @Suppress("UnstableApiUsage")
    includeBuild("gradle/plugins")

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "AndroidProjectTemplate"

val modules = listOf(
    "feature-sample",
)

modules.forEach { filePath ->
    val (type, name) = filePath.split("-")
    val newProjectName = ":$type:$name"
    include(newProjectName)
}

include(":app")
include(":apiclient")
includeBuild("tools/api-client-generator")
