package com.pasichnyi.cleanarchitecturekmm.presentation.rootView


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import com.pasichnyi.cleanarchitecturekmm.presentation.theme.Theme

internal val darkmodeState = mutableStateOf(false)
internal val safeAreaState = mutableStateOf(PaddingValues())
internal val SafeArea = compositionLocalOf { safeAreaState }
internal val DarkMode = compositionLocalOf { darkmodeState }

@Composable
internal fun RootView() {
    Theme {
        Content()
    }
    val darkMode = isSystemInDarkTheme()
    LaunchedEffect(key1 = Unit, block = {
        darkmodeState.value = darkMode
    })

//    when (val screen = screenState) {
//        is Screen.List ->
//            openArticlesList(
//                onItemClick = { screenState = Screen.Details(article = it) }
//            )
//
//        is Screen.Details ->
//            openArticleDetails(
//                article = screen.article,
//                onBack = { screenState = Screen.List }
//            )
//    }
}
