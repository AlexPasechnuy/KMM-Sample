package com.pasichnyi.cleanarchitecturekmm.di

import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepositoryImpl
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetLocalArticlesInteractor
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIHelperIOS : KoinComponent {
    val articlesRepository : ArticlesRepositoryImpl by inject()

    val getLocalArticlesInteractor : GetLocalArticlesInteractor by inject()
    val fetchArticlesInteractor : FetchArticlesInteractor by inject()
}