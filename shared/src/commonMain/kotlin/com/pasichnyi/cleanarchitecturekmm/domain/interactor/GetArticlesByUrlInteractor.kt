package com.pasichnyi.cleanarchitecturekmm.domain.interactor

import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepository
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

class GetArticlesByUrlInteractor(
    private val articlesRepository: ArticlesRepository
) {

    suspend operator fun invoke(url: String): List<Article> =
        articlesRepository.getArticlesByUrl(url)
}