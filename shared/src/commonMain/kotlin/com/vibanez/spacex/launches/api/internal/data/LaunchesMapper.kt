package com.vibanez.spacex.launches.api.internal.data

import com.vibanez.spacex.domain.model.ApiLaunch
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import com.vibanez.spacex.launches.api.internal.domain.model.LaunchStatus
import com.vibanez.spacex.launches.api.internal.domain.model.RocketLaunch

internal fun ApiLaunch.toDomain(): RocketLaunch {
    return RocketLaunch(
        id = id,
        rocketName = name,
        launchDate = dateUtc.toLocalDateTime(TimeZone.UTC).date,
        status = when (success) {
            true -> LaunchStatus.Success
            false -> LaunchStatus.Error
            null -> LaunchStatus.Unknown
        }
    )
}