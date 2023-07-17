package com.vibanez.spacex.root.repository

import com.vibanez.spacex.domain.model.DistanceUnit
import com.vibanez.spacex.domain.model.MassUnit
import com.vibanez.spacex.domain.model.RocketSettings
import com.vibanez.spacex.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class DefaultSettingsRepository : SettingsRepository {
    private val rocketSettings = MutableStateFlow(
        RocketSettings(
            mass = MassUnit.Kg,
            height = DistanceUnit.Meters,
            diameter = DistanceUnit.Meters,
            payloadWeight = MassUnit.Kg
        )
    )

    override val currentSettings: RocketSettings = rocketSettings.value

    override fun updateSettings(settings: RocketSettings) {
        rocketSettings.value = settings
    }

    override fun observeRocketSettings(): StateFlow<RocketSettings> {
        return rocketSettings.asStateFlow()
    }
}