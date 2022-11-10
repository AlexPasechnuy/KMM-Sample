package com.pasichnyi.cleanarchitecturekmm.domain.interactor

import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepository
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

class CacheArticlesInteractor(
    private val articlesRepository: ArticlesRepository
) {

    suspend operator fun invoke(articles: List<Article>) =
        articlesRepository.cacheArticles(articles)
}