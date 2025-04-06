plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.halulkin.designsystem"
}

dependencies {
    implementation(project(":core"))

    // Compose
    implementation(platform(libs.android.compose.bom))
    implementation(libs.android.compose.ui.tooling.preview)
    implementation(libs.android.compose.material3)
    implementation(libs.android.core)
}