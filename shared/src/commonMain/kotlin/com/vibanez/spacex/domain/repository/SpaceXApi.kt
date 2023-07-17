package com.vibanez.spacex.domain.repository

import com.vibanez.spacex.domain.model.Launch
import com.vibanez.spacex.domain.model.Rocket

interface SpaceXApi {
    suspend fun getRockets(): List<Rocket>
    suspend fun getLaunches(): List<Launch>
}