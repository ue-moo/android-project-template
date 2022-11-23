package jp.yumemi.tech.messageGenerator.generator

import com.google.common.truth.Truth
import com.github.uemoo.tech.messageGenerator.converter.MessageFactory
import com.github.uemoo.tech.messageGenerator.generator.StringResourceGenerator
import com.github.uemoo.tech.messageGenerator.model.CsvRow
import org.junit.Test

class StringResourceGeneratorTest {

    private val testTarget = StringResourceGenerator()
    private val messageFactory = MessageFactory()

    @Test
    fun generateXml() {
        val csv = listOf(
            CsvRow(messageId = "test", "日本語１"),
        )

        val messagesJa = csv.map {
            messageFactory.createMessage(it, CsvRow::textJa)
        }

        val result = testTarget.generateString(messagesJa)

        Truth.assertThat(result).isEqualTo("<resources>\n    <string name=\"test\">日本語１</string>\n</resources>")
    }
}
