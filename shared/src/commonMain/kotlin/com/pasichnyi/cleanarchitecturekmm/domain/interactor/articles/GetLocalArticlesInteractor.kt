package com.pasichnyi.cleanarchitecturekmm.domain.interactor.articles

import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepository
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

class GetLocalArticlesInteractor(
    private val articlesRepository: ArticlesRepository
) {

    suspend operator fun invoke(): List<Article> = articlesRepository.getAllLocal()
}