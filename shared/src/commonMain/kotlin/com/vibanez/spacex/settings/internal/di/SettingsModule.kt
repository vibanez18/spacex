package com.vibanez.spacex.settings.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.vibanez.spacex.settings.internal.presentation.SettingsFeature

internal val settingsModule = module {
    factoryOf(::SettingsFeature)
}