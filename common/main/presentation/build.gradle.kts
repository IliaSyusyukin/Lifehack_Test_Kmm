plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:companies:api"))
                api(project(":common:core"))

                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}