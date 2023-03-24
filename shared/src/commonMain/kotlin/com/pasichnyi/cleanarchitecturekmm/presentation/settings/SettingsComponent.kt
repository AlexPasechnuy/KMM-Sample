package com.pasichnyi.cleanarchitecturekmm.presentation.settings

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface SettingsComponent {
    val model: Value<Model>

    data class Model(
        val item: String,
    )
}

class DefaultSettingsComponent(
    componentContext: ComponentContext,
) : SettingsComponent {
    override val model: Value<SettingsComponent.Model> =
        MutableValue(SettingsComponent.Model(item = "Item 11"))

}