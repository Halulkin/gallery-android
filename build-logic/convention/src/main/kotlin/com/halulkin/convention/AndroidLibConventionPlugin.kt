package com.halulkin.convention

import com.android.build.gradle.LibraryExtension
import com.halulkin.convention.config.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            extensions.configure<LibraryExtension> {
                configureAndroid(this)
            }
        }
    }
}