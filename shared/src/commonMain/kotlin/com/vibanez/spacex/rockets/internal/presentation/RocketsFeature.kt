package com.vibanez.spacex.rockets.internal.presentation

import com.vibanez.spacex.domain.model.RocketSettings
import com.vibanez.spacex.domain.repository.SettingsRepository
import com.vibanez.spacex.feature.CoroutineFeature
import com.vibanez.spacex.flow.AnyStateFlow
import com.vibanez.spacex.flow.wrapToAny
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import com.vibanez.spacex.rockets.api.data.RocketsUiState
import com.vibanez.spacex.rockets.internal.data.RocketRepository
import kotlin.coroutines.cancellation.CancellationException

internal class RocketsFeature(
    private val rocketRepository: RocketRepository,
    private val settingsRepository: SettingsRepository
) : CoroutineFeature() {
    private val _state = MutableStateFlow<RocketsUiState>(RocketsUiState.Loading)
    val state: AnyStateFlow<RocketsUiState> = _state.wrapToAny()

    init {
        observeSettings()
    }

    fun onTryAgainClick() {
        loadRockets(settings = settingsRepository.currentSettings)
    }

    private fun observeSettings() {
        settingsRepository
            .observeRocketSettings()
            .onEach { loadRockets(it) }
            .launchIn(coroutineScope)
    }

    private fun loadRockets(settings: RocketSettings) {
        coroutineScope.launch {
            _state.value = RocketsUiState.Loading
            runCatchingCancellable {
                rocketRepository.getRockets()
            }.onSuccess { rockets ->
                _state.value = RocketsUiState.Data(rockets.map { it.toUiModel(settings) })
            }.onFailure {
                _state.value = RocketsUiState.Error
            }
        }
    }
}

inline fun <R> runCatchingCancellable(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Throwable) {
        if (e is CancellationException) {
            throw e
        }
        Result.failure(e)
    }
}