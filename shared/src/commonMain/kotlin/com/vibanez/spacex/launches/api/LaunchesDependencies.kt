package com.vibanez.spacex.launches.api

import com.vibanez.spacex.domain.repository.SpaceXApi
import com.vibanez.spacex.launches.api.data.LaunchesMemoryCache

interface LaunchesDependencies {
    val spaceXApi: SpaceXApi
    val memoryCache: LaunchesMemoryCache
}