package com.github.uemoo.plugins.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("plugins.primitive.android.library")
            apply("plugins.primitive.android.kotlin")
            apply("plugins.primitive.android.compose")
            apply("plugins.primitive.android.hilt")
        }
    }
}
