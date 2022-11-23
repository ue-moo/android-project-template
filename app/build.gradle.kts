plugins {
    id("plugins.primitive.android.application")
    id("plugins.primitive.android.kotlin")
    id("plugins.primitive.android.compose")
    id("plugins.primitive.android.hilt")
}

android.namespace = "com.github.uemoo.androidprojecttemplate"

dependencies {
    implementation(projects.feature.sample)

    implementation(libs.composeMaterialIcons)
    implementation(libs.composeMaterial3WindowSizeClass)
    implementation(libs.androidXChromeCustomTabs)
    implementation(libs.androidxNavigationCompose)
    implementation(libs.androidxStartup)
    implementation(libs.androidxAppCompat)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.material3)
    implementation(libs.androidxSplashScreen)
}
