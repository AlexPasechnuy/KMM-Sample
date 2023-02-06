package com.pasichnyi.cleanarchitecturekmm.presentation.newssection.newslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

@Composable
internal fun openArticlesList(onItemClick: (Article) -> Unit) {
    NewsListView().openArticlesList(onItemClick)
}

internal class NewsListView {

    @Composable
    fun openArticlesList(onItemClick: (Article) -> Unit) {

        val model = remember { NewsListStore() }
        val state = model.state
        ArticlesList(state.items, onItemClick)
    }


    @Composable
    internal fun ArticlesList(
        articles: List<Article>,
        onItemClick: (Article) -> Unit
    ) {
        LazyColumn {
            articles.map { item { ArticleCard(it, onItemClick) } }
        }
    }

    @Composable
    private fun ArticleCard(article: Article, onItemClick: (Article) -> Unit) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(article)
                },
        ) {
            Column {
                Text(
                    text = article.author ?: "Unknown author",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = article.content ?: "Unknown text",
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}