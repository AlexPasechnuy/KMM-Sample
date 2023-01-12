package com.pasichnyi.cleanarchitecturekmm.presentation.NewsList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetLocalArticlesInteractor
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class NewsListStore : KoinComponent {

    private val getLocalArticlesInteractor: GetLocalArticlesInteractor by inject()
    private val fetchArticlesInteractor: FetchArticlesInteractor by inject()

    var state: NewsListState by mutableStateOf(initialState())
        private set

    // TODO("Change runblocking")
    private fun initialState(): NewsListState = runBlocking {
        fetchArticlesInteractor()
        NewsListState(
            items = getLocalArticlesInteractor()
        )
    }

    private inline fun setState(update: NewsListState.() -> NewsListState) {
        state = state.update()
    }

    data class NewsListState(
        val items: List<Article> = emptyList(),
    )
}