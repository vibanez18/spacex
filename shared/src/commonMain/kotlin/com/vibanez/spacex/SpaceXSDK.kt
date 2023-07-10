package com.vibanez.spacex

import RocketLaunch
import com.vibanez.spacex.infrastructure.cache.Database
import com.vibanez.spacex.infrastructure.cache.DatabaseDriverFactory
import com.vibanez.spacex.infrastructure.rest.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return when {
            cachedLaunches.isNotEmpty() && !forceReload -> cachedLaunches
            else -> api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}