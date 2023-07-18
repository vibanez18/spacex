package com.vibanez.spacex.launches.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.vibanez.spacex.flow.AnyStateFlow
import com.vibanez.spacex.koin.ComponentKoinContext
import com.vibanez.spacex.launches.api.data.LaunchesUiState
import org.koin.core.parameter.parametersOf
import com.vibanez.spacex.launches.api.internal.di.createLaunchesModules
import com.vibanez.spacex.launches.api.internal.presentation.LaunchesFeature

class LaunchesComponent(
    override val rocketName: String,
    private val rocketId: String,
    private val navigateBack: () -> Unit,
    dependencies: LaunchesDependencies,
    componentContext: ComponentContext
) : Launches, ComponentContext by componentContext {
    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createLaunchesModules(dependencies)
    )

    private val feature: LaunchesFeature = instanceKeeper.getOrCreate {
        scope.get(parameters = { parametersOf(rocketId) })
    }

    override val state: AnyStateFlow<LaunchesUiState> = feature.state

    override fun onBackClicked() {
        navigateBack()
    }

    override fun onTryAgainClick() {
        feature.onTryAgainClick()
    }
}