package apiClientGenerator.usecase

import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.config.CodegenConfigurator
import java.io.File
import javax.inject.Inject

class GenerateModelFilesUseCase @Inject constructor() {
    operator fun invoke(swaggerFile: File, destDir: File, packageName: String) {
        val configurator: CodegenConfigurator = CodegenConfigurator().apply {
            setGeneratorName("kotlin")
            setInputSpec(swaggerFile.absolutePath)
            setOutputDir(destDir.absolutePath)
            addAdditionalProperty("useCoroutines", "true")
            addAdditionalProperty("library", "multiplatform")
            addAdditionalProperty("enumPropertyNaming", "UPPERCASE")
        }

        DefaultGenerator().opts(configurator.toClientOptInput()).generate()
    }
}
