package com.vibanez.spacex.infrastructure.rest

import com.vibanez.spacex.domain.model.Launch
import com.vibanez.spacex.domain.model.Rocket
import com.vibanez.spacex.domain.repository.SpaceXApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path

class DefaultSpaceXApi(
    private val httpClient: HttpClient
) : SpaceXApi {
    override suspend fun getRockets(): List<Rocket> {
        return httpClient.get {
            url { path("v4/rockets") }
        }.body()
    }

    override suspend fun getLaunches(): List<Launch> {
        return httpClient.get {
            url { path("v5/launches") }
        }.body()
    }
}