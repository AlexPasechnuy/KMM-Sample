package com.pasichnyi.cleanarchitecturekmm.presentation.newssection.articledetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

@Composable
internal fun openArticleDetails(url: String) {
    ArticleDetailsView().openArticleDetails(url)
}

internal class ArticleDetailsView {

    @Composable
    fun openArticleDetails(url: String) {
        val model = remember { ArticleDetailsStore(url) }
        val state = model.state


        ArticleDetails(state.item)
    }

    @Composable
    internal fun ArticleDetails(article: Article) {

        Surface(color = MaterialTheme.colors.primary) {
            Column {
                Text(
                    text = article.title,
                    fontSize = 30.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = article.content ?: "*No content available*",
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

