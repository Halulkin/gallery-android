buildscript {
    dependencies {
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.hilt.android.plugin)
    }
}

plugins {
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.spotless)
    alias(libs.plugins.detekt)
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    apply(plugin = "com.diffplug.spotless")

    detekt {
        config.setFrom("$rootDir/detekt-config.yml")
        buildUponDefaultConfig = true
    }
    spotless {
        kotlin {
            target("src/**/*.kt")
            ktlint().editorConfigOverride(
                mapOf(
                    "android" to "true",
                    "ktlint_function_naming_ignore_when_annotated_with" to "Composable",
                ),
            )
        }
    }
}