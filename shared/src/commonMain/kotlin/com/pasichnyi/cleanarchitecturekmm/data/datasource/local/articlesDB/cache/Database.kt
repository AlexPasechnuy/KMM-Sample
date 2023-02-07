package com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.cache

import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticle
import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticleSource
import com.pasichnyi.cleanarchitecturekmm.shared.cache.AppDatabase


class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllArticles()
            dbQuery.removeAllSources()
        }
    }

    internal fun getAllArticles(): List<DataArticle> {
        return dbQuery.selectAllArticlesInfo(::mapArticlesSelecting).executeAsList()
    }

    private fun mapArticlesSelecting(
        sourceName: String,
        author: String?,
        title: String,
        description: String?,
        url: String,
        urlToImage: String?,
        publishTime: String?,
        content: String?,
        name: String?
    ): DataArticle {
        return DataArticle(
            source = DataArticleSource(
                name = sourceName,
            ),
            author = author,
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishTime,
            content = content,
        )
    }

    internal fun insertArticles(articles: List<DataArticle>) {
        dbQuery.transaction {
            articles.forEach { article ->
                val dbSource =
                    dbQuery.selectSourceByName(article.source.name).executeAsOneOrNull()
                if (dbSource == null) {
                    insertSource(article.source)
                }
                insertArticle(article)
            }
        }
    }

    internal fun getArticleByUrl(url: String) : List<DataArticle>{
        return dbQuery.selectArticleByUrl(url = url, mapper = ::mapArticlesSelecting).executeAsList()
    }

    private fun insertSource(source: DataArticleSource) {
        dbQuery.insertSource(
            name = source.name,
        )
    }

    private fun insertArticle(article: DataArticle) {
        dbQuery.insertArticle(
            sourceName = article.source.name,
            author = article.author,
            title = article.title,
            description = article.description,
            url = article.url,
            urlToImage = article.urlToImage,
            publishTime = article.publishedAt,
            content = article.content
        )
    }
}