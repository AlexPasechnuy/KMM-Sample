package com.pasichnyi.cleanarchitecturekmm.domain.interactor.articles

import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepository

class ClearDbInteractor(
    private val repository: ArticlesRepository,
) {

    suspend operator fun invoke() = repository.clearLocalDatabase()
}