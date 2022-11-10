package com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB

import com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.cache.Database
import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticle

class LocalArticlesDatasource(private val database: Database) {

    fun getAllArticles(): List<DataArticle> = database.getAllArticles()

    fun clearDatabase() = database.clearDatabase()

    fun insertArticles(articles: List<DataArticle>) = database.insertArticles(articles)
}