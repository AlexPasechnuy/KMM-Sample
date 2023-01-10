package com.pasichnyi.cleanarchitecturekmm.UI.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

@Composable
internal fun ArticlesList(articles: List<Article>) {
    LazyColumn {
        articles.map { item { ArticleCard(it) } }
    }
}

@Composable
private fun ArticleCard(article: Article) {
    Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {

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