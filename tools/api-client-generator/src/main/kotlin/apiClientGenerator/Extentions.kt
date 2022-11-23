package apiClientGenerator

import java.io.File

/**
 * 指定したファイルが Kotlin ファイルか判定する
 */
internal val File.isKtFile: Boolean get() = isFile && name.endsWith(".kt")

/**
 * 指定したディレクトリ下の Kotlin ファイルをすべて削除する
 */
internal fun File.deleteAllKtFiles(onDelete: (File) -> Unit) = listFiles()
    ?.asSequence()
    ?.filter { it.isKtFile }
    ?.forEach {
        it.delete()
        onDelete(it)
    }

/**
 * 指定したディレクトリ下の Kotlin ファイルからモデルのファイルを生成する
 */
internal fun File.generateModelFiles(
    destDir: File,
    replaced: (String) -> String,
    onGenerate: (File) -> Unit,
) = walkTopDown()
    .asSequence()
    .filter { it.isKtFile }
    .forEach {
        val content = replaced(it.readText())
        val destFile = File(destDir, it.name)
        destFile.writeText(content)
        onGenerate(it)
    }
