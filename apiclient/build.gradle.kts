// VersionCatalog向けのWORKAROUND
// https://youtrack.jetbrains.com/issue/KTIJ-19369/False-positive-cant-be-called-in-this-context-by-implicit-receiver-with-plugins-in-Gradle-version-catalogs-as-a-TOML-file#focus=Comments-27-5181027.0-0

plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    id(libs.plugins.kotlinJvm.get().pluginId)

    @Suppress("DSL_SCOPE_VIOLATION")
    id(libs.plugins.kotlinKapt.get().pluginId)

    id("plugins.primitive.kotlin.serialization")
}

dependencies {
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinSerializationJson)
    implementation(libs.daggerHiltCore)
    implementation(libs.okHttpCore)
    implementation(libs.retrofit)
    kapt(libs.daggerHiltCompiler)
}

val apiClientGeneratorConfiguration: Configuration by configurations.creating

dependencies {
    apiClientGeneratorConfiguration("com.github.uemoo.tech:api-client-generator")
}

val generatedPackageName = "net.github.uemoo.generated"
val inputSwaggerFile = rootProject.file("openapi.yaml")
val temporaryModelDir = File(buildDir, "temporary-model")
val temporaryApiDir = File(buildDir, "temporary-api")
val generatedSourceDir = "$projectDir/src/main/java"

val apiClientGenerator by tasks.creating(JavaExec::class) {
    classpath = apiClientGeneratorConfiguration
    mainClass.set("MainKt")

    this.args = listOf(
        inputSwaggerFile.toString(),
        temporaryModelDir.toString(),
        temporaryApiDir.toString(),
        generatedSourceDir,
        generatedPackageName,
    )
}
