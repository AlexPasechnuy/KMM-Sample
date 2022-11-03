package com.pasichnyi.cleanarchitecturekmm.domain.interactor

import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepository
import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepositoryImpl
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

class GetAllArticlesInteractor {

    // TODO("DI")
    private val articlesRepository: ArticlesRepository = ArticlesRepositoryImpl()

    suspend operator fun invoke(): List<Article> = articlesRepository.getAll();
}