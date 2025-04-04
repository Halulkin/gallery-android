plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.halulkin.core"
}

dependencies {
    // Kotlin
    implementation(libs.kotlin)
    implementation(libs.kotlin.serialization.json)

    // Compose
    implementation(platform(libs.android.compose.bom))
    implementation(libs.android.compose.foundation)

    // Injection
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Networking
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.okhttp.logger)

    // Other
    implementation(libs.timber)
}