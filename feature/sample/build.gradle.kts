plugins {
    id("plugins.convention.android.feature")
}

android.namespace = "com.github.uemoo.feature.sample"

dependencies {
    implementation(libs.hiltNavigationCompose)
}
