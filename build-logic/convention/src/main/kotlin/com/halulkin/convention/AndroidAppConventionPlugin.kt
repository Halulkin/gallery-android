package com.halulkin.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidAppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configure<ApplicationExtension> {
            compileSdk = AndroidConfiguration.COMPILE_SDK
            defaultConfig {
                targetSdk = AndroidConfiguration.TARGET_SDK
                minSdk = AndroidConfiguration.MIN_SDK
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
}