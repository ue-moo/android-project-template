package com.github.uemoo.tech.messageGenerator.usecase

import com.github.uemoo.tech.messageGenerator.converter.MessageFactory
import com.github.uemoo.tech.messageGenerator.generator.StringResourceGenerator
import com.github.uemoo.tech.messageGenerator.model.CsvRow
import com.github.uemoo.tech.messageGenerator.repository.MessageCsvRepository
import java.io.File

class GenerateStringResourceUseCase(
    private val messageCsvRepository: MessageCsvRepository,
    private val generator: StringResourceGenerator,
) {
    operator fun invoke(
        inputFilename: String,
        resDir: String,
        messageFactory: MessageFactory,
    ) {
        val rawList = messageCsvRepository.load(File(inputFilename))

        val list = rawList
            .filter { it.messageId.isNotEmpty() }

        val valuesJaDir = File(resDir, "values").also { it.mkdirs() }
        val outputFilenameJa = File(valuesJaDir, "message_generated.xml")
        val messagesJa = list.map {
            messageFactory.createMessage(it, CsvRow::textJa)
        }
        generator.save(outputFilenameJa, messagesJa)

        println("[GEN] $outputFilenameJa")
    }
}
