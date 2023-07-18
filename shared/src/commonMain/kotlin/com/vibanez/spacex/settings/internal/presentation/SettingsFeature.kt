package com.vibanez.spacex.settings.internal.presentation

import com.vibanez.spacex.domain.model.DistanceUnit
import com.vibanez.spacex.domain.model.MassUnit
import com.vibanez.spacex.domain.model.RocketSettings
import com.vibanez.spacex.domain.repository.SettingsRepository
import com.vibanez.spacex.feature.CoroutineFeature
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class SettingsFeature(
    private val settingsRepository: SettingsRepository
) : CoroutineFeature() {
    val state: StateFlow<RocketSettings> = settingsRepository
        .observeRocketSettings()
        .stateIn(
            coroutineScope,
            SharingStarted.Eagerly,
            settingsRepository.currentSettings
        )

    fun onHeightChanged(value: DistanceUnit) {
        settingsRepository.updateSettings(state.value.copy(height = value))
    }

    fun onDiameterChanged(value: DistanceUnit) {
        settingsRepository.updateSettings(state.value.copy(diameter = value))
    }

    fun onMassChanged(value: MassUnit) {
        settingsRepository.updateSettings(state.value.copy(mass = value))
    }

    fun onPayloadWeightChanged(value: MassUnit) {
        settingsRepository.updateSettings(state.value.copy(payloadWeight = value))
    }
}