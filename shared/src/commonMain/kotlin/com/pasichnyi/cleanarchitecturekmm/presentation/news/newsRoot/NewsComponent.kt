package com.pasichnyi.cleanarchitecturekmm.presentation.news.newsRoot

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article
import com.pasichnyi.cleanarchitecturekmm.presentation.news.details.ArticleDetailsComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.news.details.DefaultArticleDetailsComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.news.list.DefaultNewsListComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.news.list.NewsListComponent

interface NewsComponent {


    val stack: Value<ChildStack<*, Child>>

    fun onArticleClick(article: Article)

    fun onCloseClick()

    sealed class Child {
        class ListChild(val component: NewsListComponent) : Child()
        class DetailsChild(val component: ArticleDetailsComponent) : Child()
    }
}

class DefaultNewsComponent(
    componentContext: ComponentContext,
) : NewsComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.List,
            handleBackButton = true,
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, NewsComponent.Child>> = _stack
    override fun onArticleClick(article: Article) {
        // TODO("Test")
        navigation.bringToFront(Config.Details(article))
    }

    override fun onCloseClick() {
        // TODO("Test")
        navigation.pop()
    }

    private fun child(config: Config, componentContext: ComponentContext): NewsComponent.Child =
        when (config) {
            is Config.Details -> NewsComponent.Child.DetailsChild(
                detailsComponent(
                    componentContext,
                    config
                )
            )

            is Config.List -> NewsComponent.Child.ListChild(listComponent(componentContext))
        }

    private fun listComponent(componentContext: ComponentContext): NewsListComponent =
        DefaultNewsListComponent(
            componentContext = componentContext,
            ::onArticleClick
        )

    private fun detailsComponent(
        componentContext: ComponentContext,
        config: Config.Details,
    ): ArticleDetailsComponent =
        DefaultArticleDetailsComponent(
            componentContext = componentContext,
            article = config.article,
            ::onCloseClick
        )

    private sealed interface Config : Parcelable {
        @Parcelize
        object List : Config

        @Parcelize
        data class Details(val article: Article) : Config
    }
}