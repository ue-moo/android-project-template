package com.github.uemoo.tech.messageGenerator.repository

import com.opencsv.CSVReader
import com.github.uemoo.tech.messageGenerator.model.CsvRow
import java.io.File
import java.io.Reader

class MessageCsvRepository {
    fun load(file: File): List<CsvRow> {
        file.inputStream().reader().use { reader ->
            return load(reader)
        }
    }

    internal fun load(reader: Reader): List<CsvRow> {
        val rawList = CSVReader(reader).use {
            it.readAll()
        }

        return rawList
            .drop(1)
            .map {
                CsvRow(
                    messageId = it[1],
                    textJa = it.getOrNull(2),
                )
            }
    }
}
