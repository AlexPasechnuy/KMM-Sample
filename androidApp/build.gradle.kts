plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.pasichnyi.cleanarchitecturekmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.pasichnyi.cleanarchitecturekmm.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

val koinAndroidVersion = "3.3.0"

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.0")
    implementation("androidx.compose.ui:ui-tooling:1.3.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
    implementation("androidx.compose.foundation:foundation:1.3.0")
    implementation("androidx.compose.material:material:1.3.0")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation ("io.insert-koin:koin-android:$koinAndroidVersion")
    implementation("com.arkivanov.decompose:extensions-compose-jetpack:1.0.0")
    implementation("com.arkivanov.decompose:extensions-android:1.0.0")
    implementation("com.arkivanov.decompose:extensions-compose-jetbrains:1.0.0-compose-experimental")
    implementation("com.arkivanov.decompose:decompose:1.0.0-compose-experimental")
}