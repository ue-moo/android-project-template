package com.github.uemoo.plugins.primitive

import com.github.uemoo.plugins.primitive.dsl.androidApplication
import com.github.uemoo.plugins.primitive.dsl.setupAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.android.application")

        androidApplication {
            setupAndroid()
        }
    }
}
