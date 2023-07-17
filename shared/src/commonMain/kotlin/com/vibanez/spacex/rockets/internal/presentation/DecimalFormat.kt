package com.vibanez.spacex.rockets.internal.presentation

expect class DecimalFormat() {
    fun format(
        double: Double,
        minFractionDigits: Int,
        maxFractionDigits: Int
    ): String
}