package com.vibanez.spacex.launches.api.internal.presentation

import com.vibanez.spacex.launches.api.data.LaunchUiModel
import com.vibanez.spacex.launches.api.internal.domain.model.RocketLaunch
import com.vibanez.spacex.rockets.internal.presentation.DatePattern
import com.vibanez.spacex.rockets.internal.presentation.format

internal fun RocketLaunch.toUiModel(): LaunchUiModel {
    return LaunchUiModel(
        id = id,
        name = rocketName,
        launchDate = launchDate.format(DatePattern.D_MMM_YYYY),
        status = status
    )
}