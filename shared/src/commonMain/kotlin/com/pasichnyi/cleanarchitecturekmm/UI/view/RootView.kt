package com.pasichnyi.cleanarchitecturekmm.UI.view


import androidx.compose.runtime.Composable
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

@Composable
internal fun RootView() = ArticlesList(
    listOf(
        Article(
            source = "Source 1",
            author = "Authow 1",
            title = "Title 1",
            description = "String",
            url = "String",
            urlToImage = "String",
            publishTime = "String",
            content = "String",
        ),
        Article(
            source = "Source 2",
            author = "Authow 2",
            title = "Title 2",
            description = "String",
            url = "String",
            urlToImage = "String",
            publishTime = "String",
            content = "String",
        ),
        Article(
            source = "Source 3",
            author = "Authow 3",
            title = "Title 3",
            description = "String",
            url = "String",
            urlToImage = "String",
            publishTime = "String",
            content = "String",
        ),
        Article(
            source = "Source 4",
            author = "Authow 4",
            title = "Title 4",
            description = "String",
            url = "String",
            urlToImage = "String",
            publishTime = "String",
            content = "String",
        )
    )
)