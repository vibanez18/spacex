package com.vibanez.spacex.rockets.internal.presentation

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

expect class DateFormat() {
    fun format(dateTime: LocalDateTime, pattern: DatePattern): String
    fun format(date: LocalDate, pattern: DatePattern): String
}