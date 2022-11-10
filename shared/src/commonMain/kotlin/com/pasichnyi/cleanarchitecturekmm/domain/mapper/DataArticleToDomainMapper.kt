package com.pasichnyi.cleanarchitecturekmm.domain.mapper

import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticle
import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticleSource
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

class DataArticleToDomainMapper {

    fun mapDataToDomain(article: DataArticle) = Article(
        source = article.source.name,
        author = article.author,
        title = article.title,
        description = article.description,
        url = article.url,
        urlToImage = article.urlToImage,
        content = article.content,
        publishTime = article.publishTime,
    )

    fun mapDomainToData(article: Article) = DataArticle(
        source = DataArticleSource(name = article.source),
        author = article.author,
        title = article.title,
        description = article.description,
        url = article.url,
        urlToImage = article.urlToImage,
        publishTime = article.publishTime,
        content = article.content
    )
}