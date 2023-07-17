package com.vibanez.spacex.rockets.api

import com.vibanez.spacex.domain.repository.SettingsRepository
import com.vibanez.spacex.domain.repository.SpaceXApi
import com.vibanez.spacex.rockets.api.data.RocketsMemoryCache

interface RocketsDependencies {
    val spaceXApi: SpaceXApi
    val settingsRepository: SettingsRepository
    val memoryCache: RocketsMemoryCache
}