package com.pasichnyi.cleanarchitecturekmm.di

import com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.LocalArticlesDatasource
import com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.cache.Database
import com.pasichnyi.cleanarchitecturekmm.data.datasource.remote.RemoteArticlesDatasource
import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepository
import com.pasichnyi.cleanarchitecturekmm.data.repository.ArticlesRepositoryImpl
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.CacheArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.ClearDbInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.FetchArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetLocalArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.interactor.GetNetworkArticlesInteractor
import com.pasichnyi.cleanarchitecturekmm.domain.mapper.DataArticleToDomainMapper
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

fun commonModule(): Module = module {
    single { RemoteArticlesDatasource() }
    single { DataArticleToDomainMapper() }
    single {
        ArticlesRepositoryImpl(
            localArticlesDatasource = LocalArticlesDatasource(
                database = Database(databaseDriverFactory = get())
            ),
            remoteArticlesDatasource = get(),
            dataArticleMapper = get(),
        )
    } bind ArticlesRepository::class
    single { CacheArticlesInteractor(get()) }
    single { ClearDbInteractor(get()) }
    single { FetchArticlesInteractor(get()) }
    single { GetLocalArticlesInteractor(get()) }
    single { GetNetworkArticlesInteractor(get()) }
}


//val articlesRepository = ArticlesRepositoryImpl(
//    localArticlesDatasource = LocalArticlesDatasource(
//        database = Database(databaseDriverFactory = DatabaseDriverFactory(context = this))
//    ),
//    remoteArticlesDatasource = RemoteArticlesDatasource(),
//    dataArticleMapper = DataArticleToDomainMapper(),
//)
//return LocalNewsListPresenter(
//getLocalArticlesInteractor = GetLocalArticlesInteractor(articlesRepository),
//fetchArticlesInteractor = FetchArticlesInteractor(articlesRepository),
//)