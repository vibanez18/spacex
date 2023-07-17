package com.vibanez.spacex.rockets.internal.data

import com.vibanez.spacex.domain.repository.SpaceXApi
import com.vibanez.spacex.rockets.api.data.RocketsMemoryCache
import com.vibanez.spacex.rockets.internal.domain.model.RocketUI

internal class RocketRepository(
    private val spaceXApi: SpaceXApi,
    private val memoryCache: RocketsMemoryCache
) {
    suspend fun getRockets(): List<RocketUI> {
        return memoryCache.get() ?: spaceXApi
            .getRockets()
            .map { it.toDomain() }
            .also { memoryCache.set(value = it) }
    }
}