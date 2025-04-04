package com.halulkin.convention

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.halulkin.convention.config.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidAppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            extensions.configure<BaseAppModuleExtension> {
                configureAndroid(commonExtension = this)
            }
        }
    }
}