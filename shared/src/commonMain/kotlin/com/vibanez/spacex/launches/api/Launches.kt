package com.vibanez.spacex.launches.api

import com.vibanez.spacex.flow.AnyStateFlow
import com.vibanez.spacex.launches.api.data.LaunchesUiState

interface Launches {
    val rocketName: String
    val state: AnyStateFlow<LaunchesUiState>

    fun onBackClicked()

    fun onTryAgainClick()
}