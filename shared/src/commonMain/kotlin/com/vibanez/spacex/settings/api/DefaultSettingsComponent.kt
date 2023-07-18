package com.vibanez.spacex.settings.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.vibanez.spacex.domain.model.DistanceUnit
import com.vibanez.spacex.domain.model.MassUnit
import com.vibanez.spacex.domain.model.RocketSettings
import com.vibanez.spacex.flow.AnyStateFlow
import com.vibanez.spacex.flow.wrapToAny
import com.vibanez.spacex.koin.ComponentKoinContext
import com.vibanez.spacex.settings.internal.di.createSettingsModules
import com.vibanez.spacex.settings.internal.presentation.SettingsFeature

class DefaultSettingsComponent(
    componentContext: ComponentContext,
    dependencies: SettingsDependencies,
    private val onDismiss: () -> Unit
) : SettingsComponent, ComponentContext by componentContext {
    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createSettingsModules(dependencies)
    )

    private val feature: SettingsFeature = instanceKeeper.getOrCreate { scope.get() }

    override val state: AnyStateFlow<RocketSettings> = feature.state.wrapToAny()

    override fun onDismissClick() {
        onDismiss()
    }

    override fun onHeightChanged(value: DistanceUnit) {
        feature.onHeightChanged(value)
    }

    override fun onDiameterChanged(value: DistanceUnit) {
        feature.onDiameterChanged(value)
    }

    override fun onMassChanged(value: MassUnit) {
        feature.onMassChanged(value)
    }

    override fun onPayloadWeightChanged(value: MassUnit) {
        feature.onPayloadWeightChanged(value)
    }
}