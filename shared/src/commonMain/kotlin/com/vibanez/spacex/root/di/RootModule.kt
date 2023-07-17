package com.vibanez.spacex.root.di

import com.vibanez.spacex.domain.repository.SettingsRepository
import com.vibanez.spacex.domain.repository.SpaceXApi
import com.vibanez.spacex.rockets.RocketsDependencies
import com.vibanez.spacex.rockets.data.RocketsMemoryCache
import com.vibanez.spacex.root.repository.DefaultSettingsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


internal val rootModule = module {
    singleOf(::DefaultSettingsRepository) bind SettingsRepository::class
    singleOf(::DefaultRocketsDependencies) bind RocketsDependencies::class
    singleOf(::DefaultLaunchesDependencies) bind LaunchesDependencies::class
    singleOf(::DefaultSettingsDependencies) bind SettingsDependencies::class
}

private class DefaultRocketsDependencies(
    override val spaceXApi: SpaceXApi,
    override val settingsRepository: SettingsRepository,
    override val memoryCache: RocketsMemoryCache
) : RocketsDependencies

private class DefaultLaunchesDependencies(
    override val spaceXApi: SpaceXApi,
    override val memoryCache: LaunchesMemoryCache
) : LaunchesDependencies

private class DefaultSettingsDependencies(
    override val settingsRepository: SettingsRepository
) : SettingsDependencies