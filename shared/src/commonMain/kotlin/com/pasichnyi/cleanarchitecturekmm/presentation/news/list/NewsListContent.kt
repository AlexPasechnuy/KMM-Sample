package com.pasichnyi.cleanarchitecturekmm.presentation.news.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.presentation.widgets.AsyncImage

@Composable
internal fun NewsListContent(component: NewsListComponent, modifier: Modifier = Modifier) {
    val model by component.model.subscribeAsState()
    when (model) {
        is NewsListComponent.State.ArticlesList -> ArticlesScreen(
            model as NewsListComponent.State.ArticlesList,
            component,
            modifier
        )

        NewsListComponent.State.Loading -> LoadingArticlesScreen()
    }
}

@Composable
internal fun LoadingArticlesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Text("Loading")
    }
}

@Composable
internal fun ArticlesScreen(
    model: NewsListComponent.State.ArticlesList,
    component: NewsListComponent,
    modifier: Modifier = Modifier
) {
    if (!model.isOnline) {
        OfflineWarning(component::refresh)
    }
    ArticlesList(model.articles, component::onArticleClicked)
}

@Composable
internal fun OfflineWarning(onRefreshClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(
                MaterialTheme.colors.error
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "You are offline",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Spacer(Modifier.weight(1f))
        Button(
            onClick = onRefreshClick,
            modifier = Modifier.padding(horizontal = 8.dp),
        ) {
            Text("Refresh")
        }
        Spacer(Modifier.width(8.dp))
    }
}

@Composable
internal fun ArticlesList(
    articles: List<Article>,
    onItemClick: (Article) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        articles.map { item { ArticleCard(it, onItemClick) } }
    }
}

@Composable
private fun ArticleCard(article: Article, onItemClick: (Article) -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                onItemClick(article)
            },
    ) {
        Row {
            article.urlToImage?.let {
                AsyncImage(
                    url = it,
                    modifier = Modifier.width(144.dp)
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            Column(
                modifier = Modifier.padding(PaddingValues(horizontal = 4.dp, vertical = 4.dp))
            ) {

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = article.author ?: "Unknown author",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                        text = article.title,
                        modifier = Modifier.padding(all = 4.dp).weight(1.0f),
                        style = MaterialTheme.typography.body2
                    )

                Spacer(modifier = Modifier.height(4.dp))

                article.publishedAt?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colors.secondaryVariant,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }
}