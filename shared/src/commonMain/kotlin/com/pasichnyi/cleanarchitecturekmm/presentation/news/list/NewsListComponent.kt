package com.pasichnyi.cleanarchitecturekmm.presentation.news.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.articles.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.articles.GetLocalArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.exception.OfflineException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface NewsListComponent {

    val model: Value<State>

    fun onArticleClicked(article: Article)

    fun refresh()

    sealed class State{

        object Loading : State()

        data class ArticlesList(
            val articles: List<Article>,
            val isOnline: Boolean,
        ) : State()
    }

}

class DefaultNewsListComponent(
    private val componentContext: ComponentContext,
    private val onArticleSelected: (article: Article) -> Unit
) : NewsListComponent, KoinComponent {

    private val fetchArticlesInteractor: FetchArticlesInteractor by inject()
    private val getLocalArticlesInteractor: GetLocalArticlesInteractor by inject()

    // TODO("Add loading state")
    override val model: MutableValue<NewsListComponent.State> =
        MutableValue(
            NewsListComponent.State.Loading
        )

    init {
        // TODO("Check how to implement without init block")
        refresh()
    }

    override fun refresh() {
        CoroutineScope(Dispatchers.Main).launch {
            val isOnline: Boolean = try {
                fetchArticlesInteractor()
                true
            } catch (ex: OfflineException) {
                false
            }
            model.value = NewsListComponent.State.ArticlesList(
                articles = getLocalArticlesInteractor(),
                isOnline = isOnline
            )

        }
    }

    override fun onArticleClicked(article: Article) {
        onArticleSelected(article)
    }
}
