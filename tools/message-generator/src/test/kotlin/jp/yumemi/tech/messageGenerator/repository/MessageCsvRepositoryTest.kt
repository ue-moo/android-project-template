package jp.yumemi.tech.messageGenerator.repository

import com.google.common.truth.Truth
import com.github.uemoo.tech.messageGenerator.model.CsvRow
import com.github.uemoo.tech.messageGenerator.repository.MessageCsvRepository
import org.junit.Test
import java.io.StringReader

private val FAKE_CSV = """
    screen,key,value,iOS
    ホーム,tabbar_home,コジマネット会員になるとお得がいっぱい!,"home_card_register_login_description"="コジマネット会員になると\nお得がいっぱい！";
""".trimIndent()

class MessageCsvRepositoryTest {

    private val testTarget = MessageCsvRepository()

    @Test
    fun load() {
        val result = StringReader(FAKE_CSV).use {
            testTarget.load(it)
        }
        println("$result")

        Truth.assertThat(result.firstOrNull())
            .isEqualTo(CsvRow(messageId = "tabbar_home", textJa = "コジマネット会員になるとお得がいっぱい!"))
    }
}
