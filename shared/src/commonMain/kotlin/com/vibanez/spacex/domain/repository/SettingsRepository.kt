package com.vibanez.spacex.domain.repository

import com.vibanez.spacex.domain.model.RocketSettings
import kotlinx.coroutines.flow.StateFlow

interface SettingsRepository {
    val currentSettings: RocketSettings

    fun updateSettings(settings: RocketSettings)
    fun observeRocketSettings(): StateFlow<RocketSettings>
}