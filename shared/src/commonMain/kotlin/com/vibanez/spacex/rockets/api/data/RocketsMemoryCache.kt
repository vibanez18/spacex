package com.vibanez.spacex.rockets.api.data

import com.vibanez.spacex.infrastructure.cache.Cache
import com.vibanez.spacex.infrastructure.cache.MemoryCache
import com.vibanez.spacex.rockets.internal.domain.model.RocketUI

class RocketsMemoryCache : Cache<List<RocketUI>> by MemoryCache()