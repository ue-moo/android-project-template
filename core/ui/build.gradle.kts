plugins {
    id("plugins.primitive.android.library")
    id("plugins.primitive.android.kotlin")
    id("plugins.primitive.android.compose")
    id("plugins.primitive.android.hilt")
}

android.namespace = "com.github.uemoo.ui"

dependencies {
    api(projects.core.domain)
}

// 文言ファイル自動生成関連コード
val messageGeneratorConfiguration: Configuration by configurations.creating

dependencies {
    messageGeneratorConfiguration("com.github.uemoo.tech:message-generator")
}

val messageGenerator by tasks.creating(JavaExec::class) {
    group = "tools"
    classpath = messageGeneratorConfiguration
    mainClass.set("com.github.uemoo.tech.messageGenerator.MainKt")
    args(
        File(rootDir, "message.csv").absolutePath,
        file("src/main/res").absolutePath,
    )
}
