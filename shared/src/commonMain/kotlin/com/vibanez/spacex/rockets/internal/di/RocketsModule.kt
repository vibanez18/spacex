package com.vibanez.spacex.rockets.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.vibanez.spacex.rockets.internal.data.RocketRepository
import com.vibanez.spacex.rockets.internal.presentation.RocketsFeature

internal val rocketsModule = module {
    factoryOf(::RocketsFeature)
    factoryOf(::RocketRepository)
}