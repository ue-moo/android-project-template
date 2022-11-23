import com.android.build.gradle.internal.tasks.factory.dependsOn

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

// ビルド時に自動的に .git/hooks/prepare-commit-msg を設定する
val copyGitPrepareCommitMsgHook by tasks.creating(Copy::class) {
    from("$rootDir/tools/git-hooks/prepare-commit-msg")
    into("$rootDir/.git/hooks/")
}

afterEvaluate {
    android.applicationVariants.configureEach {
        val variant = this
        variant.javaCompileProvider.dependsOn(copyGitPrepareCommitMsgHook)
    }
}
