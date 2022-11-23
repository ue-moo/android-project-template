package com.github.uemoo.plugins.primitive.dsl

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import java.util.*

fun DependencyHandlerScope.implementation(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>
) {
    add("implementation", artifact.get())
}

fun DependencyHandlerScope.debugImplementation(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>
) {
    add("debugImplementation", artifact.get())
}

fun DependencyHandlerScope.androidTestImplementation(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>
) {
    add("androidTestImplementation", artifact.get())
}

fun DependencyHandlerScope.testImplementation(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>
) {
    add("testImplementation", artifact.get())
}

private fun DependencyHandlerScope.api(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>
) {
    add("api", artifact.get())
}

fun DependencyHandlerScope.detektPlugins(
    artifact: Optional<Provider<MinimalExternalModuleDependency>>
) {
    add("detektPlugins", artifact.get())
}

val Project.libs get() = extensions.getByType<VersionCatalogsExtension>().named("libs")
