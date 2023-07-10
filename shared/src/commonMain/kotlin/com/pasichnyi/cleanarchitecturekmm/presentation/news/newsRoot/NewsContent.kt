package com.pasichnyi.cleanarchitecturekmm.presentation.news.newsRoot

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.pasichnyi.cleanarchitecturekmm.presentation.news.details.ArticleDetailsContent
import com.pasichnyi.cleanarchitecturekmm.presentation.news.list.NewsListContent

@Composable
internal fun NewsContent(component: NewsComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is NewsComponent.Child.ListChild -> NewsListContent(component = child.component)
            is NewsComponent.Child.DetailsChild -> ArticleDetailsContent(component = child.component)
        }
    }
}