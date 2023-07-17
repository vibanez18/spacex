package com.vibanez.spacex.rockets.internal.presentation

import com.vibanez.spacex.domain.model.DistanceUnit
import com.vibanez.spacex.domain.model.MassUnit
import com.vibanez.spacex.domain.model.RocketSettings
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc
import com.vibanez.spacex.rockets.api.data.RocketParamUiModel
import com.vibanez.spacex.rockets.api.data.RocketStageUiModel
import com.vibanez.spacex.rockets.api.data.RocketUiModel
import com.vibanez.spacex.rockets.internal.domain.model.PayloadWeight
import com.vibanez.spacex.rockets.internal.domain.model.RocketUI
import com.vibanez.spacex.rockets.internal.domain.model.RocketDiameter
import com.vibanez.spacex.rockets.internal.domain.model.RocketHeight
import com.vibanez.spacex.rockets.internal.domain.model.RocketMass
import com.vibanez.spacex.rockets.internal.domain.model.RocketStage
import kotlinx.datetime.LocalDate

internal fun RocketUI.toUiModel(settings: RocketSettings): RocketUiModel {
    return RocketUiModel(
        id = id,
        name = name,
        params = listOf(
            height.toUiModel(settings.height),
            diameter.toUiModel(settings.diameter),
            mass.toUiModel(settings.mass),
            payloadWeight.toUiModel(settings.payloadWeight)
        ),
        firstFlight = firstFlight.format(DatePattern.D_MMM_YYYY),
        country = country,
        costPerLaunch = formatCostPerLaunch(costPerLaunch),
        firstStage = firstStage.toUiModel(),
        secondStage = secondStage.toUiModel(),
        flickrImage = flickrImage
    )
}

private fun formatCostPerLaunch(value: Long): StringDesc {
    val valueInMillions = value / 1_000_000
    return StringDesc.ResourceFormatted(RocketsR.strings.rocket_cost_value, valueInMillions)
}

private fun RocketStage.toUiModel(): RocketStageUiModel {
    return RocketStageUiModel(
        engines = engines.toString(),
        fuelAmountTons = fuelAmountTons.format(),
        burnTimeSec = burnTimeSec?.toString() ?: "—"
    )
}

private fun RocketHeight.toUiModel(unit: DistanceUnit): RocketParamUiModel {
    val value = when (unit) {
        DistanceUnit.Meters -> meters
        DistanceUnit.Feet -> feet
    }

    val title = StringDesc.ResourceFormatted(RocketsR.strings.rocket_param_height, unit.value)
    return RocketParamUiModel(title = title, value.format())
}

private fun RocketDiameter.toUiModel(unit: DistanceUnit): RocketParamUiModel {
    val value = when (unit) {
        DistanceUnit.Meters -> meters
        DistanceUnit.Feet -> feet
    }
    val title = StringDesc.ResourceFormatted(RocketsR.strings.rocket_param_diameter, unit.value)
    return RocketParamUiModel(title = title, value.format())
}

private fun RocketMass.toUiModel(unit: MassUnit): RocketParamUiModel {
    val value = when (unit) {
        MassUnit.Kg -> kg
        MassUnit.Lb -> lb
    }
    val title = StringDesc.ResourceFormatted(RocketsR.strings.rocket_param_mass, unit.value)
    return RocketParamUiModel(title = title, value.toString())
}

private fun PayloadWeight.toUiModel(unit: MassUnit): RocketParamUiModel {
    val value = when (unit) {
        MassUnit.Kg -> kg
        MassUnit.Lb -> lb
    }
    val title = StringDesc.ResourceFormatted(RocketsR.strings.rocket_param_payload, unit.value)
    return RocketParamUiModel(title = title, value.toString())
}

fun Double.format(): String {
    return DecimalFormat().format(
        double = this,
        minFractionDigits = 0,
        maxFractionDigits = 2
    )
}

fun LocalDate.format(pattern: DatePattern): String {
    return DateFormat().format(this, pattern)
}

enum class DatePattern(val value: String) {
    D_MMM_YYYY("d MMMM, yyyy")
}