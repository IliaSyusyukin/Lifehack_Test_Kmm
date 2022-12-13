plugins {
    id("com.android.application")
    id("org.jetbrains.compose")
    kotlin("android")
}

android {
    namespace = "com.lifehack.testapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.lifehack.testapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
//
//    buildTypes {
//        release {
//            minifyEnabled = false
//            proguardFiles = getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
}

dependencies {

    implementation(project(":common:core"))
    implementation(project(":common:companies:api"))
    implementation(project(":common:general-compose"))
    implementation(project(":common:general-core"))

    implementation(Dependencies.Android.Compose.runtime)
    implementation(Dependencies.Android.Compose.ui)
    implementation(Dependencies.Android.Compose.material)
    implementation(Dependencies.Android.Compose.icons)
    implementation(Dependencies.Android.Compose.tooling)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'
}