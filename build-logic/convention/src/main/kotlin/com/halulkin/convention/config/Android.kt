package com.halulkin.convention.config

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion

private const val COMPILE_SDK = 35
private const val MIN_SDK = 28

internal fun configureAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        compileSdk = COMPILE_SDK
        defaultConfig {
            minSdk = MIN_SDK
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        buildFeatures {
            buildConfig = true
            compose = true
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }
}
