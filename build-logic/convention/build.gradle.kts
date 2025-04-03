plugins {
    `kotlin-dsl`
}

group = "com.halulkin.buildlogic"


dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("conventionAndroidLib") {
            id = libs.plugins.convention.android.library.get().pluginId
            implementationClass = "com.halulkin.convention.AndroidLibConventionPlugin"
        }

        register("conventionAndroidApp") {
            id = libs.plugins.convention.android.application.get().pluginId
            implementationClass = "com.halulkin.convention.AndroidAppConventionPlugin"
        }
    }
}
