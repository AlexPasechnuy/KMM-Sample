package com.pasichnyi.cleanarchitecturekmm.presentation.newssection.articledetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetArticlesByUrlInteractor
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArticleDetailsStore(url: String) : KoinComponent{

    private val getArticlesByUrlInteractor: GetArticlesByUrlInteractor by inject()

    var state: ArticleDetailsState by mutableStateOf(getState(url))
        private set

    private fun getState(url: String): ArticleDetailsState = runBlocking {
        val article: Article? = getArticlesByUrlInteractor(url).firstOrNull()
        ArticleDetailsState(
            article!!   // TODO("Change")
        )
    }

    data class ArticleDetailsState(
        val item: Article,
    )
}