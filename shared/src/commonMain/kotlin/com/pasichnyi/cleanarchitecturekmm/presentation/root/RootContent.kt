package com.pasichnyi.cleanarchitecturekmm.presentation.root

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.pasichnyi.cleanarchitecturekmm.presentation.news.newsRoot.NewsContent
import com.pasichnyi.cleanarchitecturekmm.presentation.settings.SettingsContent
import kotlinx.coroutines.launch

internal val darkmodeState = mutableStateOf(false)
internal val safeAreaState = mutableStateOf(PaddingValues())
internal val SafeArea = compositionLocalOf { safeAreaState }
internal val DarkMode = compositionLocalOf { darkmodeState }

@OptIn(ExperimentalMaterialApi::class, ExperimentalDecomposeApi::class)
@Composable
internal fun NewRootContent(component: RootComponent, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        topBar = {
            Box(modifier = Modifier.background(MaterialTheme.colors.primary)) {
                TopAppBar(
                    modifier = Modifier.padding(
                        start = SafeArea.current.value.calculateStartPadding(LayoutDirection.Ltr),
                        top = SafeArea.current.value.calculateTopPadding(),
                        end = SafeArea.current.value.calculateEndPadding(LayoutDirection.Ltr)
                    ),
                    title = { Text("Current route") },
                    navigationIcon = {
                        Icon(
                            Icons.Default.Menu,
                            "test",
                            modifier = Modifier.clickable {
                                scope.launch { scaffoldState.drawerState.open() }
                            }
                        )
                    }
                )
            }
        },
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerContent = {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF966DE7),
                                    Color(0xFF755CD4),
                                    Color(0xFF4C48C1)
                                )
                            )
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Clear Architecture Compose MPP",
                        style = MaterialTheme.typography.h5,
                        color = Color.Red,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                Column {
                    ListItem(
                        text = { Text("News") },
                        modifier = Modifier.clickable {
                            component.onNewsClick()
                            scope.launch { scaffoldState.drawerState.close() }
                        }
                    )
                    ListItem(
                        text = { Text("Settings") },
                        modifier = Modifier.clickable {
                            component.onSettingsClick()
                            scope.launch { scaffoldState.drawerState.close() }
                        }
                    )
                }
            }
        },
        scaffoldState = scaffoldState
    ) {
        Children(
            stack = component.stack,
            modifier = modifier,
            animation = stackAnimation(fade() + scale()),
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.NewsChild -> NewsContent(component = child.component)
                is RootComponent.Child.SettingsChild -> SettingsContent(component = child.component)
            }
        }
    }


}