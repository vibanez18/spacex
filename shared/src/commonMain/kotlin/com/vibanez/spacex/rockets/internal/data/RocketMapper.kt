package com.vibanez.spacex.rockets.internal.data

import com.vibanez.spacex.domain.model.Rocket
import com.vibanez.spacex.rockets.internal.domain.model.PayloadWeight
import com.vibanez.spacex.rockets.internal.domain.model.RocketUI
import com.vibanez.spacex.rockets.internal.domain.model.RocketDiameter
import com.vibanez.spacex.rockets.internal.domain.model.RocketHeight
import com.vibanez.spacex.rockets.internal.domain.model.RocketMass
import com.vibanez.spacex.rockets.internal.domain.model.RocketStage

internal fun Rocket.toDomain(): RocketUI {
    return RocketUI(
        id = id,
        name = name,
        costPerLaunch = costPerLaunch,
        firstFlight = firstFlight,
        country = country,
        height = RocketHeight(meters = height.meters, feet = height.feet),
        diameter = RocketDiameter(meters = diameter.meters, feet = diameter.feet),
        mass = RocketMass(kg = mass.kg, lb = mass.lb),
        payloadWeight = payloadWeights.first().let {
            PayloadWeight(id = it.id, name = it.name, kg = it.kg, lb = it.lb)
        },
        firstStage = RocketStage(
            engines = firstStage.engines,
            fuelAmountTons = firstStage.fuelAmountTons,
            burnTimeSec = firstStage.burnTimeSec
        ),
        secondStage = RocketStage(
            engines = secondStage.engines,
            fuelAmountTons = secondStage.fuelAmountTons,
            burnTimeSec = secondStage.burnTimeSec
        ),
        flickrImage = flickrImages.first()
    )
}