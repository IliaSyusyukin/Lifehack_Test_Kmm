plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {

                //implementation(project(":common:companies:data"))

                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)

                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.negotiation)
                implementation(Dependencies.Ktor.kotlin_json)
                implementation(Dependencies.Ktor.logging)

                api(Dependencies.Kodein.core)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
            }
        }
    }
}