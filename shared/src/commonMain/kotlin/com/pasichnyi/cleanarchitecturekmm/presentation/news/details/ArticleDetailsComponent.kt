package com.pasichnyi.cleanarchitecturekmm.presentation.news.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

interface ArticleDetailsComponent {
    val models: Value<Model>

    data class Model(
        val article: Article
    )

    fun onCloseClicked()
}

class DefaultArticleDetailsComponent(
    componentContext: ComponentContext,
    private val article: Article,
    private val onCloseClicked: () -> Unit
) : ArticleDetailsComponent {
    override val models: Value<ArticleDetailsComponent.Model>
        get() = MutableValue(
            ArticleDetailsComponent.Model(article)
        )

    override fun onCloseClicked() {
        onCloseClicked
    }

}