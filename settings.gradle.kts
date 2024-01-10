pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    repositories {
        maven(url  = "./flutter_module")
        maven(url = "https://storage.googleapis.com/download.flutter.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    repositories {
        maven(url  = "./flutter_module")
        maven(url = "https://storage.googleapis.com/download.flutter.io")
    }
}

rootProject.name = "Flutter Integration In Android"
include(":app")
 