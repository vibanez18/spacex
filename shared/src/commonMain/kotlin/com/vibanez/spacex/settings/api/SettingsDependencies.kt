package com.vibanez.spacex.settings.api

import com.vibanez.spacex.domain.repository.SettingsRepository


interface SettingsDependencies {
    val settingsRepository: SettingsRepository
}