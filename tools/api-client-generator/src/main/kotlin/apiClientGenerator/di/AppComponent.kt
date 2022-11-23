package apiClientGenerator.di

import apiClientGenerator.usecase.CopyApiFilesUseCase
import apiClientGenerator.usecase.CopyModelFilesUseCase
import apiClientGenerator.usecase.GenerateApiFilesUseCase
import apiClientGenerator.usecase.GenerateModelFilesUseCase
import apiClientGenerator.usecase.GenerateProguardFileUseCase
import dagger.Component

// TODO: 要素の確認
@Component
interface AppComponent {
    val copyModelFilesUseCase: CopyModelFilesUseCase
    val copyApiFilesUseCase: CopyApiFilesUseCase
    val generateModelFilesUseCase: GenerateModelFilesUseCase
    val generateApiFilesUseCase: GenerateApiFilesUseCase
    val generateProguardFileUseCase: GenerateProguardFileUseCase
}
