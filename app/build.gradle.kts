plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.convention.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.halulkin.gallery"
    defaultConfig {
        applicationId = "com.halulkin.gallery"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":designsystem"))

    // Kotlin
    implementation(libs.kotlin)
    implementation(libs.kotlin.coroutines.android)
    implementation(libs.kotlin.serialization.json)

    // Arch Components
    implementation(libs.hilt.navigation.compose)

    // Compose
    implementation(platform(libs.android.compose.bom))
    implementation(libs.android.compose.material3)
    implementation(libs.android.compose.ui.tooling)
    implementation(libs.android.compose.ui.tooling.preview)
    implementation(libs.android.lifecycle.runtime.compose)
    implementation(libs.android.navigation.compose)

    // Injection
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Networking
    implementation(libs.retrofit)

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.timber)
}