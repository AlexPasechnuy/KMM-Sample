package com.pasichnyi.cleanarchitecturekmm.presentation.settings

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.articles.ClearDbInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.articles.GetLocalArticlesInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface SettingsComponent {
    val model: Value<Model>

    data class Model(
        val localArticlesCount: Int
    )

    suspend fun refresh()

    fun clearCache()
}

class DefaultSettingsComponent(
    componentContext: ComponentContext,
) : SettingsComponent, KoinComponent {

    private val clearDbInteractor: ClearDbInteractor by inject()
    private val getLocalArticlesInteractor: GetLocalArticlesInteractor by inject()

    override val model: MutableValue<SettingsComponent.Model> =
        MutableValue(SettingsComponent.Model(0))

    init {
        CoroutineScope(Dispatchers.Main).launch {
            refresh()
        }
    }

    override suspend fun refresh() {
        model.value = SettingsComponent.Model(
            localArticlesCount = getLocalArticlesInteractor().size
        )
    }

    override fun clearCache() {
        CoroutineScope(Dispatchers.Main).launch {
            refresh()
            clearDbInteractor()
            refresh()
        }
    }
}