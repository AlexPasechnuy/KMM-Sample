package com.pasichnyi.cleanarchitecturekmm.presentation.newssection.articledetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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

        Scaffold {
            Column(
                modifier = Modifier.padding(PaddingValues(horizontal = 8.dp, vertical = 8.dp))
            ) {
                Text(
                    text = article.title,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = article.author ?: "*No content available*",
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = article.content ?: "*No content available*",
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

