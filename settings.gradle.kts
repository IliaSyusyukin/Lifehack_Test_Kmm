pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Lifehack_Test_Kmm"
include(":androidApp")
include(":common:core")
include(":common:core-compose")
include(":common:core-utils")
include(":common:main:api")
include(":common:main:presentation")
include(":common:main:compose")
include(":common:companies:api")
//include(":common:companies:presentation")
include(":common:companies:data")
//include(":common:companies:compose")
include(":common:general-core")
include(":common:general-compose")