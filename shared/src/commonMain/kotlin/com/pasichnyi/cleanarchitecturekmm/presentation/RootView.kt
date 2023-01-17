package com.pasichnyi.cleanarchitecturekmm.presentation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.pasichnyi.cleanarchitecturekmm.Screen
import com.pasichnyi.cleanarchitecturekmm.presentation.articledetails.openArticleDetails
import com.pasichnyi.cleanarchitecturekmm.presentation.newslist.openArticlesList

@Composable
internal fun RootView() {
    var screenState by remember { mutableStateOf<Screen>(Screen.List) }

    when (val screen = screenState) {
        is Screen.List ->
            openArticlesList(
                onItemClick = { screenState = Screen.Details(article = it) }
            )

        is Screen.Details ->
            openArticleDetails(
                article = screen.article,
                onBack = { screenState = Screen.List }
            )
    }
}