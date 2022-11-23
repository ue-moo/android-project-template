package apiClientGenerator.usecase

import java.io.File
import javax.inject.Inject

class GenerateProguardFileUseCase @Inject constructor() {
    operator fun invoke(proguardFile: File, packageName: String) {
        proguardFile.parentFile.mkdirs()

        proguardFile.writeText(
            """
            -keep, allowobfuscation, allowoptimization class $packageName.model.**
            """.trimIndent(),
        )
    }
}
