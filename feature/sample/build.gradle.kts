plugins {
    id("plugins.convention.android.feature")
}

android.namespace = "com.github.uemoo.feature.sample"

dependencies {
    implementation(projects.core.ui)
    implementation(libs.hiltNavigationCompose)
}
