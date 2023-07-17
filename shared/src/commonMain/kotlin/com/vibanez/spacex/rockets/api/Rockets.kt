package com.vibanez.spacex.rockets.api

import com.vibanez.spacex.flow.AnyStateFlow
import com.vibanez.spacex.rockets.api.data.RocketsUiState

interface Rockets {
    val state: AnyStateFlow<RocketsUiState>

    fun onLaunchesClick(rocketId: String)
    fun onSettingsClick()

    fun onTryAgainClick()
}