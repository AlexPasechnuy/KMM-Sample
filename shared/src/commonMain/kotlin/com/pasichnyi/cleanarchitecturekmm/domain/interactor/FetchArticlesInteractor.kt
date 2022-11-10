package com.pasichnyi.cleanarchitecturekmm.domain.interactor

import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepository

class FetchArticlesInteractor(
    private val articlesRepository: ArticlesRepository
) {

    suspend operator fun invoke() = articlesRepository.fetchArticles()
}