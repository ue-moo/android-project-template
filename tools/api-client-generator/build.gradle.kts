plugins {
    val kotlinVersion = "1.6.20"
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    // https://plugins.gradle.org/plugin/org.openapi.generator
    // https://github.com/OpenAPITools/openapi-generator
    // https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin
    id("org.openapi.generator") version "5.4.0"

    application
}

group = "com.github.uemoo.tech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val daggerVersion = "2.41"
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")

    implementation("org.openapitools:openapi-generator:5.4.0")
}

tasks.test {
    useJUnit()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

application {
    mainClass.set("MainKt")
}

val inputSwaggerFile = file("openapi.yaml")
val temporaryModelDir = File(buildDir, "temporary-model")
val temporaryApiDir = File(buildDir, "temporary-api")
val generatedSourceDir = File(projectDir, "src/test/kotlin/")
val generatedPackageName = "apiClientGenerator.generated"

tasks.named<JavaExec>("run") {
    this.args = listOf(
        inputSwaggerFile.toString(),
        temporaryModelDir.toString(),
        temporaryApiDir.toString(),
        generatedSourceDir.toString(),
        generatedPackageName,
    )
}
