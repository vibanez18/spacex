package com.vibanez.spacex.launches.api.data

import com.vibanez.spacex.launches.api.internal.domain.model.LaunchStatus

data class LaunchUiModel(
    val id: String,
    val name: String,
    val launchDate: String,
    val status: LaunchStatus
)