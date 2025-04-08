plugins {
    alias(libs.plugins.convention.android.application)
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
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

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

    // Testing
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.timber)
    implementation(libs.telephoto.zoomable)
}