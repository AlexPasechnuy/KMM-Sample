package com.pasichnyi.cleanarchitecturekmm.presentation.articledetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

internal class ArticleDetailsStore(article: Article) {

    var state: ArticleDetailsState by mutableStateOf(ArticleDetailsState(article))
        private set

    data class ArticleDetailsState(
        val item: Article,
    )
}