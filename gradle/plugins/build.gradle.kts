plugins {
    `kotlin-dsl`
}

group = "buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(libs.androidGradlePlugin)
    implementation(libs.kotlinGradlePlugin)
    implementation(libs.hiltGradlePlugin)
    implementation(libs.kotlinSerializationPlugin)
}

gradlePlugin {
    plugins {
        // Primitives
        val primitivePackage = "com.github.uemoo.plugins.primitive"

        register("androidApplication") {
            id = "plugins.primitive.android.application"
            implementationClass = "$primitivePackage.AndroidApplicationPlugin"
        }
        register("androidCompose") {
            id = "plugins.primitive.android.compose"
            implementationClass = "$primitivePackage.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "plugins.primitive.android.hilt"
            implementationClass = "$primitivePackage.AndroidHiltPlugin"
        }
        register("androidKotlin") {
            id = "plugins.primitive.android.kotlin"
            implementationClass = "$primitivePackage.AndroidKotlinPlugin"
        }
        register("androidLibrary") {
            id = "plugins.primitive.android.library"
            implementationClass = "$primitivePackage.AndroidLibraryPlugin"
        }
        register("kotlinSerialization") {
            id = "plugins.primitive.kotlin.serialization"
            implementationClass = "$primitivePackage.KotlinSerializationPlugin"
        }
        // Conventions
        val conventionPackage = "com.github.uemoo.plugins.convention"

        register("androidFeature") {
            id = "plugins.convention.android.feature"
            implementationClass = "$conventionPackage.AndroidFeaturePlugin"
        }
    }
}
