package com.vibanez.spacex.infrastructure.provider

import kotlinx.serialization.json.Json

class JsonProvider {
    fun get() = Json {
        isLenient = true
        ignoreUnknownKeys = true
        useAlternativeNames = false
    }
}