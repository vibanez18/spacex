package com.vibanez.spacex.rockets.api.data

sealed class RocketsUiState {
    object Loading : RocketsUiState()

    object Error : RocketsUiState()

    data class Data(
        val rockets: List<RocketUiModel>
    ) : RocketsUiState()
}