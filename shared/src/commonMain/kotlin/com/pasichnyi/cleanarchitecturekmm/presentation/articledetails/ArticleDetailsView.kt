package com.pasichnyi.cleanarchitecturekmm.presentation.articledetails

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
internal fun openArticleDetails(article: Article, onBack: () -> Unit) {
    ArticleDetailsView().openArticleDetails(article, onBack)
}

internal class ArticleDetailsView {

    @Composable
    fun openArticleDetails(article: Article, onBack: () -> Unit) {
        val model = remember { ArticleDetailsStore(article) }
        val state = model.state

        ArticleDetails(state.item, onBack)
    }

    @Composable
    internal fun ArticleDetails(article: Article, onBack: () -> Unit) {

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
                Button(
                    onClick = onBack,
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text(text = "Back")
                }
            }
        }
    }
}

