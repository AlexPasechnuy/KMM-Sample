package com.pasichnyi.cleanarchitecturekmm.domain.entity

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
data class Article(
    val source: String,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
) : Parcelable {
    companion object {
        val sampleData = listOf(
            Article(
                source = "Source 1",
                author = "Author 1",
                title = "Sample title 1",
                description = "Description 1",
                url = "",
                urlToImage = "",
                publishedAt = "today",
                content = "Lorem ipsum ... 1"
            ),
            Article(
                source = "Source 2",
                author = "Author 2",
                title = "Sample title 2",
                description = "Description 2",
                url = "",
                urlToImage = "",
                publishedAt = "today",
                content = "Lorem ipsum ... 2"
            ),
            Article(
                source = "Source 3",
                author = "Author 3",
                title = "Sample title 3",
                description = "Description 3",
                url = "",
                urlToImage = "",
                publishedAt = "today",
                content = "Lorem ipsum ... 3"
            )
        )
    }
}