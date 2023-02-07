package com.pasichnyi.cleanarchitecturekmm.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class DataArticle(
    val source: DataArticleSource,
    val author: String? = null,
    val title: String,
    val description: String? = null,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null,
)
