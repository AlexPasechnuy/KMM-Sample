package com.pasichnyi.cleanarchitecturekmm.presentation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.pasichnyi.cleanarchitecturekmm.presentation.news.newsRoot.DefaultNewsComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.news.newsRoot.NewsComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.settings.DefaultSettingsComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.settings.SettingsComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onNewsClick()

    fun onSettingsClick()

    sealed class Child {
        class NewsChild(val component: NewsComponent) : Child()
        class SettingsChild(val component: SettingsComponent) : Child()
    }
}

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.News,
            handleBackButton = true,
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, RootComponent.Child>> = _stack
    override fun onNewsClick() {
        navigation.bringToFront(Config.News)
    }

    override fun onSettingsClick() {
        navigation.bringToFront(Config.Settings)
    }

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.News -> RootComponent.Child.NewsChild(newsComponent(componentContext))
            is Config.Settings -> RootComponent.Child.SettingsChild(
                settingsComponent(
                    componentContext,
                )
            )
        }

    private fun newsComponent(componentContext: ComponentContext): NewsComponent =
        DefaultNewsComponent(
            componentContext = componentContext,
        )

    private fun settingsComponent(
        componentContext: ComponentContext,
    ): SettingsComponent =
        DefaultSettingsComponent(
            componentContext = componentContext,
        )

    @Parcelize
    private sealed interface Config : Parcelable {
        object News : Config
        object Settings : Config
    }
}