package com.vibanez.spacex.rockets.internal.presentation

import dev.icerock.moko.resources.AssetResource
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.FileResource
import dev.icerock.moko.resources.FontResource
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.PluralsResource
import dev.icerock.moko.resources.ResourceContainer
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.utils.loadableBundle
import platform.Foundation.NSBundle

public actual object RocketsR {
    private val bundle: NSBundle by lazy { NSBundle.loadableBundle("ru.alexpanov.spacex.rockets.MR") }

    private val contentHash: String = "0787fd0130e471f67f82ce5881b09a4f"

    public actual object strings : ResourceContainer<StringResource> {
        public actual val rocket_param_height: StringResource = StringResource(resourceId =
        "rocket_param_height", bundle = bundle)

        public actual val rocket_param_diameter: StringResource = StringResource(resourceId =
        "rocket_param_diameter", bundle = bundle)

        public actual val rocket_param_mass: StringResource = StringResource(resourceId =
        "rocket_param_mass", bundle = bundle)

        public actual val rocket_param_payload: StringResource = StringResource(resourceId =
        "rocket_param_payload", bundle = bundle)

        public actual val rocket_first_flight: StringResource = StringResource(resourceId =
        "rocket_first_flight", bundle = bundle)

        public actual val rocket_country: StringResource = StringResource(resourceId = "rocket_country",
            bundle = bundle)

        public actual val rocket_cost_per_launch: StringResource = StringResource(resourceId =
        "rocket_cost_per_launch", bundle = bundle)

        public actual val rocket_cost_value: StringResource = StringResource(resourceId =
        "rocket_cost_value", bundle = bundle)

        public actual val rocket_stage_first: StringResource = StringResource(resourceId =
        "rocket_stage_first", bundle = bundle)

        public actual val rocket_stage_second: StringResource = StringResource(resourceId =
        "rocket_stage_second", bundle = bundle)

        public actual val rocket_stage_engines_count: StringResource = StringResource(resourceId =
        "rocket_stage_engines_count", bundle = bundle)

        public actual val rocket_stage_fuel_amount: StringResource = StringResource(resourceId =
        "rocket_stage_fuel_amount", bundle = bundle)

        public actual val rocket_stage_fuel_amount_unit: StringResource = StringResource(resourceId =
        "rocket_stage_fuel_amount_unit", bundle = bundle)

        public actual val rocket_stage_burn_time: StringResource = StringResource(resourceId =
        "rocket_stage_burn_time", bundle = bundle)

        public actual val rocket_stage_burn_time_unit: StringResource = StringResource(resourceId =
        "rocket_stage_burn_time_unit", bundle = bundle)

        public actual val rocket_show_launches_btn: StringResource = StringResource(resourceId =
        "rocket_show_launches_btn", bundle = bundle)

        public override val nsBundle: NSBundle = bundle
    }

    public actual object plurals : ResourceContainer<PluralsResource> {
        public override val nsBundle: NSBundle = bundle
    }

    public actual object images : ResourceContainer<ImageResource> {
        public override val nsBundle: NSBundle = bundle
    }

    public actual object fonts : ResourceContainer<FontResource> {
        public override val nsBundle: NSBundle = bundle
    }

    public actual object files : ResourceContainer<FileResource> {
        public override val nsBundle: NSBundle = bundle
    }

    public actual object colors : ResourceContainer<ColorResource> {
        public override val nsBundle: NSBundle = bundle
    }

    public actual object assets : ResourceContainer<AssetResource> {
        public override val nsBundle: NSBundle = bundle
    }
}
