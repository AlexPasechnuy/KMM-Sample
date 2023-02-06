package com.pasichnyi.cleanarchitecturekmm.data.repository

import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

interface ArticlesRepository {

    suspend fun getAllRemote(): List<Article>
    suspend fun getAllLocal(): List<Article>
    suspend fun fetchArticles()
    suspend fun cacheArticles(articles: List<Article>)
    suspend fun clearLocalDatabase()
    suspend fun getArticlesByUrl(url: String) :  List<Article>
}