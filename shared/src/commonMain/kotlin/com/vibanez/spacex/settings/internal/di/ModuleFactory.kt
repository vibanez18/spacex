package com.vibanez.spacex.settings.internal.di

import org.koin.core.module.Module
import org.koin.dsl.module
import com.vibanez.spacex.settings.api.SettingsDependencies

internal fun createSettingsModules(dependencies: SettingsDependencies): List<Module> {
    return listOf(
        settingsModule,
        module {
            factory { dependencies.settingsRepository }
        }
    )
}