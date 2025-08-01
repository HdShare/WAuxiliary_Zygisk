@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "WAuxvZygisk"
includeBuild("build-logic")
include(":app")
