plugins {
    id("plugins.primitive.android.library")
    id("plugins.primitive.android.kotlin")
    id("plugins.primitive.android.hilt")
    id("plugins.primitive.kotlin.serialization")
}

android.namespace = "com.github.uemoo.data"

dependencies {
    implementation(projects.core.domain)
}
