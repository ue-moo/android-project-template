package com.github.uemoo.tech.messageGenerator

import com.github.uemoo.tech.messageGenerator.converter.MessageFactory
import com.github.uemoo.tech.messageGenerator.generator.StringResourceGenerator
import com.github.uemoo.tech.messageGenerator.repository.MessageCsvRepository
import com.github.uemoo.tech.messageGenerator.usecase.GenerateStringResourceUseCase

fun main(args: Array<String>) {
    val (
        inputFilename: String,
        resDir: String,
    ) = args

    val csvRepository = MessageCsvRepository()
    val messageFactory = MessageFactory()
    val generator = StringResourceGenerator()
    val generateStringResourceUseCase = GenerateStringResourceUseCase(csvRepository, generator)
    generateStringResourceUseCase(
        inputFilename = inputFilename,
        resDir = resDir,
        messageFactory = messageFactory,
    )
}
