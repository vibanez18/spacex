package com.vibanez.spacex.launches.api.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.vibanez.spacex.launches.api.internal.data.LaunchesRepository
import com.vibanez.spacex.launches.api.internal.presentation.LaunchesFeature

internal val rocketsModule = module {
    factoryOf(::LaunchesFeature)
    factoryOf(::LaunchesRepository)
}