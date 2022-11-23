package com.github.uemoo.tech.messageGenerator.converter

import com.github.uemoo.tech.messageGenerator.model.CsvRow
import com.github.uemoo.tech.messageGenerator.model.Message

class MessageFactory {
    fun createMessage(csvRow: CsvRow, getText: CsvRow.() -> String?): Message {
        return Message(
            messageId = csvRow.messageId.normalizeMessageId(),
            text = csvRow.getText()?.replaceLf() ?: "",
        )
    }

    private fun String.replaceLf(): String {
        return replace("\n", "\\n")
    }

    private fun String.normalizeMessageId(): String {
        return replace(RE_INVALID_MESSAGE_ID_CHARS, "_")
    }

    companion object {
        private val RE_INVALID_MESSAGE_ID_CHARS = """[^a-zA-Z0-9]+""".toRegex()
    }
}
