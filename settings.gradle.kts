pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { setUrl("https://repo1.maven.org/maven2/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://repo1.maven.org/maven2/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
    }
}

rootProject.name = "msz_core"
include(":app")
include(":core")
