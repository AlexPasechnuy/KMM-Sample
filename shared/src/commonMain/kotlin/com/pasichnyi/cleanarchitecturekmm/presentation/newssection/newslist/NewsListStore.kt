package com.pasichnyi.cleanarchitecturekmm.presentation.newssection.newslist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetLocalArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.exception.OfflineException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class NewsListStore : KoinComponent {

    private val getLocalArticlesInteractor: GetLocalArticlesInteractor by inject()
    private val fetchArticlesInteractor: FetchArticlesInteractor by inject()

    var state: NewsListState by mutableStateOf(NewsListState())

    init {
        refresh()
    }

    fun refresh() = CoroutineScope(Dispatchers.Default).launch {
        var isOnline: Boolean
        try {
            fetchArticlesInteractor()
            isOnline = true
        } catch (ex: OfflineException) {
            isOnline = false
        }
        setState {
            NewsListState(
                items = getLocalArticlesInteractor(),
                isOnline = isOnline
            )
        }
    }

    private inline fun setState(update: NewsListState.() -> NewsListState) {
        state = state.update()
    }

    data class NewsListState(
        val items: List<Article> = emptyList(),
        var isOnline: Boolean = false,
    )
}