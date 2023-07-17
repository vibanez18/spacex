package com.vibanez.spacex.rockets.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.vibanez.spacex.flow.AnyStateFlow
import com.vibanez.spacex.koin.ComponentKoinContext
import com.vibanez.spacex.rockets.api.data.RocketUiModel
import com.vibanez.spacex.rockets.api.data.RocketsUiState
import com.vibanez.spacex.rockets.internal.di.createRocketsModules
import com.vibanez.spacex.rockets.internal.presentation.RocketsFeature

class RocketsComponent(
    componentContext: ComponentContext,
    dependencies: RocketsDependencies,
    private val navigateLaunches: (RocketUiModel) -> Unit,
    private val navigateSettings: () -> Unit,
) : Rockets, ComponentContext by componentContext {
    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createRocketsModules(dependencies)
    )

    private val feature: RocketsFeature = instanceKeeper.getOrCreate { scope.get() }

    override val state: AnyStateFlow<RocketsUiState> = feature.state

    override fun onLaunchesClick(rocketId: String) {
        val data = state.value as? RocketsUiState.Data ?: return
        val rocket = data.rockets.single { it.id == rocketId }
        navigateLaunches(rocket)
    }

    override fun onSettingsClick() {
        navigateSettings()
    }

    override fun onTryAgainClick() {
        feature.onTryAgainClick()
    }
}