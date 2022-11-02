package com.pasichnyi.cleanarchitecturekmm.domain.entity

data class Article(
    val source: String,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishTime: String?,
    val content: String?,
)