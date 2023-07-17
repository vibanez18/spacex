package com.vibanez.spacex.android.root

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.vibanez.spacex.root.SettingsComponent

interface Root {
    val childStack: Value<ChildStack<*, Child>>

    val childSlot: Value<ChildSlot<*, SlotChild>>

    fun dismissSlotChild()

    sealed class SlotChild {
        class SettingsChild(val component: SettingsComponent) : SlotChild()
    }

    fun onBackClicked()

    sealed class Child {
        class RocketsChild(val component: Rockets) : Child()
        class LaunchesChild(val component: Launches) : Child()
    }
}