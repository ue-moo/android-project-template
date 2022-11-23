package com.github.uemoo.plugins.primitive

import com.github.uemoo.plugins.primitive.dsl.android
import com.github.uemoo.plugins.primitive.dsl.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.android")
        }

        android {
            kotlinOptions {
                // Treat all Kotlin warnings as errors (disabled by default)
                allWarningsAsErrors = properties["warningsAsErrors"] as? Boolean ?: false

                freeCompilerArgs = freeCompilerArgs + listOf(
//              "-opt-in=kotlin.RequiresOptIn",
                    // Enable experimental coroutines APIs, including Flow
//              "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xcontext-receivers"
                )

                jvmTarget = org.gradle.api.JavaVersion.VERSION_1_8.toString()
            }
        }
    }
}
