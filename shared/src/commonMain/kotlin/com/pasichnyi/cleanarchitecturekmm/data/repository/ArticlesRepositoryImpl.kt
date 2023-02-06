package com.pasichnyi.cleanarchitecturekmm.data.repository

import com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.LocalArticlesDatasource
import com.pasichnyi.cleanarchitecturekmm.data.datasource.remote.RemoteArticlesDatasource
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.mapper.DataArticleToDomainMapper

class ArticlesRepositoryImpl(
    private val localArticlesDatasource: LocalArticlesDatasource,
    private val remoteArticlesDatasource: RemoteArticlesDatasource,
    private val dataArticleMapper: DataArticleToDomainMapper
) : ArticlesRepository {

    override suspend fun getAllRemote(): List<Article> =
        remoteArticlesDatasource
            .getAll()
            .map { dataArticleMapper.mapDataToDomain(it) }


    override suspend fun getAllLocal(): List<Article> =
        localArticlesDatasource.getAllArticles().map { dataArticleMapper.mapDataToDomain(it) }


    override suspend fun fetchArticles() {
        cacheArticles(getAllRemote())
    }

    override suspend fun cacheArticles(articles: List<Article>) {
        localArticlesDatasource.insertArticles(
            articles = articles.map {
                dataArticleMapper.mapDomainToData(
                    it
                )
            }
        )
    }

    override suspend fun clearLocalDatabase() =
        localArticlesDatasource.clearDatabase()

    override suspend fun getArticlesByUrl(url: String): List<Article> =
        localArticlesDatasource.getArticlesByUrl(url).map { dataArticleMapper.mapDataToDomain(it) }

}