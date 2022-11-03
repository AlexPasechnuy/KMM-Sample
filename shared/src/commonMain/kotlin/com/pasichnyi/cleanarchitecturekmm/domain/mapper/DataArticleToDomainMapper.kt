package com.pasichnyi.cleanarchitecturekmm.domain.mapper

import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticle
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

class DataArticleToDomainMapper {

    fun mapDataToDomain(article: DataArticle): Article {
        return Article(
            source = article.source.name ?: "Unknown",
            author = article.author,
            title = article.title,
            description = article.description,
            url = article.url,
            urlToImage = article.urlToImage,
            content = article.content,
            publishTime = article.publishTime,
        )
    }
}