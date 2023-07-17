package com.vibanez.spacex.root.di

import com.vibanez.spacex.domain.repository.SpaceXApi
import com.vibanez.spacex.infrastructure.provider.HttpClientProvider
import com.vibanez.spacex.infrastructure.provider.JsonProvider
import com.vibanez.spacex.infrastructure.rest.DefaultSpaceXApi
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {
    factoryOf(::HttpClientProvider)
    singleOf(HttpClientProvider::get)

    factoryOf(::JsonProvider)
    singleOf(JsonProvider::get)

    singleOf(::DefaultSpaceXApi) bind SpaceXApi::class

    singleOf(::RocketsMemoryCache)
    singleOf(::LaunchesMemoryCache)
}