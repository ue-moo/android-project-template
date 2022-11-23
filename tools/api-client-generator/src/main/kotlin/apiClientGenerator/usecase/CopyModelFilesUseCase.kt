package apiClientGenerator.usecase

import apiClientGenerator.deleteAllKtFiles
import apiClientGenerator.generateModelFiles
import java.io.File
import javax.inject.Inject

class CopyModelFilesUseCase @Inject constructor() {
    operator fun invoke(srcDir: File, destDir: File, packageName: String) {
        destDir.mkdirs()

        destDir.deleteAllKtFiles { deleted ->
            println("[CopyModelFilesUseCase] ${deleted.name} を削除しました")
        }

        srcDir.generateModelFiles(
            destDir = destDir,
            replaced = { it.replaceContent(packageName) },
            onGenerate = { generated ->
                println("[CopyModelFilesUseCase] ${generated.name} を生成しました")
            }
        )
    }

    private fun String.replaceContent(packageName: String): String {
        return this
            .replace(RE_PACKAGE, "package $packageName.model")
            .replace(RE_IMPORT_MODEL, "import $packageName.model.")
    }

    companion object {
        private val RE_PACKAGE = """^package .*""".toRegex(option = RegexOption.MULTILINE)
        private val RE_IMPORT_MODEL = """^import org\.openapitools\.client.models\.""".toRegex(option = RegexOption.MULTILINE)
    }
}
