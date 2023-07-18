package com.vibanez.spacex.launches.api.data

import com.vibanez.spacex.infrastructure.cache.Cache
import com.vibanez.spacex.infrastructure.cache.MemoryCache
import com.vibanez.spacex.launches.api.internal.domain.model.RocketLaunch


class LaunchesMemoryCache : Cache<List<RocketLaunch>> by MemoryCache()