package com.github.uemoo.tech.messageGenerator.generator

import com.github.uemoo.tech.messageGenerator.model.Message
import org.redundent.kotlin.xml.PrintOptions
import org.redundent.kotlin.xml.xml
import java.io.File

class StringResourceGenerator {
    private val printOptions = PrintOptions(
        pretty = true,
        singleLineTextElements = true,
        indent = " ".repeat(4),
    )

    fun save(file: File, list: List<Message>) {
        val xmlText = generateString(list)

        file.writeText(xmlText)
    }

    internal fun generateString(list: List<Message>): String {
        val document = xml("resources") {
            for (row in list) {
                "string" {
                    attribute("name", row.messageId)
                    -row.text
                }
            }
        }

        return document.toString(printOptions)
    }
}
