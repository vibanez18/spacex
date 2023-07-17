package com.vibanez.spacex.rockets.internal.presentation

import dev.icerock.moko.resources.AssetResource
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.FileResource
import dev.icerock.moko.resources.FontResource
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.ResourceContainer
import dev.icerock.moko.resources.StringResource

expect object RocketsR {
    object strings : ResourceContainer<StringResource> {
        val rocket_param_height: StringResource

        val rocket_param_diameter: StringResource
        val rocket_param_mass: StringResource
        val rocket_param_payload: StringResource
        val rocket_first_flight: StringResource
        val rocket_country: StringResource
        val rocket_cost_per_launch: StringResource
        val rocket_cost_value: StringResource
        val rocket_stage_first: StringResource
        val rocket_stage_second: StringResource
        val rocket_stage_engines_count: StringResource
        val rocket_stage_fuel_amount: StringResource
        val rocket_stage_fuel_amount_unit: StringResource
        val rocket_stage_burn_time: StringResource
        val rocket_stage_burn_time_unit: StringResource
        val rocket_show_launches_btn: StringResource
    }

    object plurals : ResourceContainer<PluralsResource>
    object images : ResourceContainer<ImageResource>
    object fonts : ResourceContainer<FontResource>
    object files : ResourceContainer<FileResource>
    object colors : ResourceContainer<ColorResource>
    object assets : ResourceContainer<AssetResource>
}