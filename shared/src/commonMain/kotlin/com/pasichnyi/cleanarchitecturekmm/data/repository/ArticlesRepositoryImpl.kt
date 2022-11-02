package com.pasichnyi.cleanarchitecturekmm.data.repository

import com.pasichnyi.cleanarchitecturekmm.data.datasource.remote.RemoteArticlesDatasource
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.domain.mapper.DataArticleToDomainMapper

class ArticlesRepositoryImpl : ArticlesRepository {

    // TODO("DI")
    private val dataSource = RemoteArticlesDatasource()
    private val dataArticleMapper = DataArticleToDomainMapper();

    override suspend fun getAll(): List<Article> =
        dataSource
            .getAll()
            .map { dataArticleMapper.mapDataToDomain(it) }

}