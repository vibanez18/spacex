package com.vibanez.spacex.settings.api

import com.vibanez.spacex.domain.model.DistanceUnit
import com.vibanez.spacex.domain.model.MassUnit
import com.vibanez.spacex.domain.model.RocketSettings
import com.vibanez.spacex.flow.AnyStateFlow

interface SettingsComponent {
    val state: AnyStateFlow<RocketSettings>

    fun onDismissClick()

    fun onHeightChanged(value: DistanceUnit)
    fun onDiameterChanged(value: DistanceUnit)
    fun onMassChanged(value: MassUnit)
    fun onPayloadWeightChanged(value: MassUnit)
}