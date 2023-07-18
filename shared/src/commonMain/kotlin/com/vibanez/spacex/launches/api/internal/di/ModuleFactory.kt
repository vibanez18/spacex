package com.vibanez.spacex.launches.api.internal.di

import com.vibanez.spacex.launches.api.LaunchesDependencies
import org.koin.core.module.Module
import org.koin.dsl.module

internal fun createLaunchesModules(dependencies: LaunchesDependencies): List<Module> {
    return listOf(
        rocketsModule,
        module {
            factory { dependencies.spaceXApi }
            factory { dependencies.memoryCache }
        }
    )
}