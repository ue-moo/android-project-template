package apiClientGenerator.usecase

import apiClientGenerator.deleteAllKtFiles
import apiClientGenerator.generateModelFiles
import java.io.File
import javax.inject.Inject

class CopyApiFilesUseCase @Inject constructor() {
    operator fun invoke(srcDir: File, destDir: File, packageName: String) {
        destDir.mkdirs()

        destDir.deleteAllKtFiles { deleted ->
            println("[CopyApiFilesUseCase] ${deleted.name} を削除しました")
        }

        srcDir.generateModelFiles(
            destDir = destDir,
            replaced = { it.replaceContent(packageName) },
            onGenerate = { generated ->
                println("[CopyApiFilesUseCase] ${generated.name} を生成しました")
            },
        )
    }

    private fun String.replaceContent(packageName: String): String {
        return this
            .replace(RE_PACKAGE, "package $packageName.api")
            .replace(RE_IMPORT_MODEL, "import $packageName.model.")
            .replace("import org.openapitools.client.infrastructure.CollectionFormats.*\n", "")
            .replace(": Response<Unit>", "")
            .replace(RE_RESPONSE_ENVELOP, "$1")
            .replace(RE_RESULT_ANY, "")
    }

    companion object {
        private val RE_PACKAGE = """^package .*""".toRegex(option = RegexOption.MULTILINE)
        private val RE_IMPORT_MODEL = """^import org\.openapitools\.client.models\.""".toRegex(option = RegexOption.MULTILINE)
        private val RE_RESPONSE_ENVELOP = """Response<(.+)>""".toRegex()
        private val RE_RESULT_ANY = """: kotlin.Any$""".toRegex(RegexOption.MULTILINE)
    }
}
