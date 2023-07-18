package com.vibanez.spacex.launches.api.internal.presentation

import com.vibanez.spacex.feature.CoroutineFeature
import com.vibanez.spacex.flow.AnyStateFlow
import com.vibanez.spacex.flow.wrapToAny
import com.vibanez.spacex.launches.api.data.LaunchesUiState
import com.vibanez.spacex.launches.api.internal.data.LaunchesRepository
import com.vibanez.spacex.rockets.internal.presentation.runCatchingCancellable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class LaunchesFeature(
    private val rocketId: String,
    private val launchesRepository: LaunchesRepository
) : CoroutineFeature() {
    private val _state = MutableStateFlow<LaunchesUiState>(LaunchesUiState.Loading)
    val state: AnyStateFlow<LaunchesUiState> = _state.wrapToAny()

    init {
        loadLaunches()
    }

    fun onTryAgainClick() {
        loadLaunches()
    }

    private fun loadLaunches() {
        coroutineScope.launch {
            _state.value = LaunchesUiState.Loading
            runCatchingCancellable {
                launchesRepository.getLaunches(rocketId)
            }.onSuccess { launches ->
                if (launches.isEmpty()) {
                    _state.value = LaunchesUiState.Empty
                } else {
                    _state.value = LaunchesUiState.Data(launches.map { it.toUiModel() })
                }
            }.onFailure {
                _state.value = LaunchesUiState.Error
            }
        }
    }
}