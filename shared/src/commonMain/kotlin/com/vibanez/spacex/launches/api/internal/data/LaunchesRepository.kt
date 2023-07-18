package com.vibanez.spacex.launches.api.internal.data

import com.vibanez.spacex.domain.repository.SpaceXApi
import com.vibanez.spacex.launches.api.data.LaunchesMemoryCache
import com.vibanez.spacex.launches.api.internal.domain.model.RocketLaunch

internal class LaunchesRepository(
    private val spaceXApi: SpaceXApi,
    private val memoryCache: LaunchesMemoryCache
) {
    suspend fun getLaunches(rocketId: String): List<RocketLaunch> {
        return memoryCache[rocketId] ?: spaceXApi.getLaunches()
            .filter { it.rocketId == rocketId }
            .map { it.toDomain() }
            .also { memoryCache[rocketId] = it }
    }
}