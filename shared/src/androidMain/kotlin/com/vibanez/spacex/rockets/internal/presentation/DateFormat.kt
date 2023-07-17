package com.vibanez.spacex.rockets.internal.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.Locale

actual class DateFormat {
    @RequiresApi(Build.VERSION_CODES.O)
    actual fun format(date: LocalDate, pattern: DatePattern): String {
        return date.toJavaLocalDate().format(pattern)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    actual fun format(dateTime: LocalDateTime, pattern: DatePattern): String {
        return dateTime.toJavaLocalDateTime().format(pattern)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun TemporalAccessor.format(pattern: DatePattern): String {
        val formatter = DateTimeFormatter.ofPattern(pattern.value, Locale.getDefault())
        return formatter.format(this)
    }
}