import apiClientGenerator.di.DaggerAppComponent
import java.io.File

// TODO: 要素の確認
fun main(args: Array<String>) {
    val (
        inputSwaggerFile,
        temporaryModelDir,
        temporaryApiDir,
        generatedSourceDir,
        generatedPackageName,
    ) = args

    val destinationDir = "$generatedSourceDir/${generatedPackageName.replace(".", "/")}"

    val modelDir = "$temporaryModelDir/src/main/kotlin/org/openapitools/client/models"
    val modelDirNew = "$destinationDir/model"
    val apiDir = "$temporaryApiDir/src/main/kotlin/org/openapitools/client/apis"
    val apiDirNew = "$destinationDir/api"
    val proguardFile = "$generatedSourceDir/resources/META-INF/proguard/apiclient.pro"

    with(DaggerAppComponent.create()) {
        generateModelFilesUseCase(File(inputSwaggerFile), File(temporaryModelDir), generatedPackageName)
        generateApiFilesUseCase(File(inputSwaggerFile), File(temporaryApiDir), generatedPackageName)
        copyModelFilesUseCase(File(modelDir), File(modelDirNew), generatedPackageName)
        copyApiFilesUseCase(File(apiDir), File(apiDirNew), generatedPackageName)
        generateProguardFileUseCase(File(proguardFile), generatedPackageName)
    }
}
