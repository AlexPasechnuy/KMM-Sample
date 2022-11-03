package com.pasichnyi.cleanarchitecturekmm.data.entity

import kotlinx.serialization.Serializable

@Serializable
class ArticlesApiResponse(
    val status: String? = null,
    val articles: List<DataArticle> = emptyList(),
)