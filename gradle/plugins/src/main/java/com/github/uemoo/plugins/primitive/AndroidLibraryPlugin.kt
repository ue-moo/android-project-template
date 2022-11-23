package com.github.uemoo.plugins.primitive

import com.github.uemoo.plugins.primitive.dsl.androidLibrary
import com.github.uemoo.plugins.primitive.dsl.setupAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.android.library")

        androidLibrary {
            setupAndroid()
        }
    }
}
