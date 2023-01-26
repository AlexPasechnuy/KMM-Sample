package com.pasichnyi.cleanarchitecturekmm.presentation.rootView

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import com.pasichnyi.cleanarchitecturekmm.presentation.newslist.openArticlesList
import com.pasichnyi.cleanarchitecturekmm.presentation.settings.Settings
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun Content() {
    val scope = rememberCoroutineScope()
    val navigator = rememberNavigator()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navBackStackEntry by navigator.currentEntry.collectAsState(null)
    val currentRoute = navBackStackEntry?.route?.route
    Scaffold(
        topBar = {
            Box(modifier = Modifier.background(MaterialTheme.colors.primary)) {
                TopAppBar(
                    modifier = Modifier.padding(
                        start = SafeArea.current.value.calculateStartPadding(LayoutDirection.Ltr),
                        top = SafeArea.current.value.calculateTopPadding(),
                        end = SafeArea.current.value.calculateEndPadding(LayoutDirection.Ltr)
                    ),
                    title = { Text(currentRoute ?: "") },
                    navigationIcon = {
                        Icon(
                            Icons.Default.Menu,
                            "test",
                            modifier = Modifier.clickable(
                                onClick = {
                                    scope.launch { scaffoldState.drawerState.open() }
                                }
                            )
                        )
                    }
                )
            }
        },
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerContent = {
            LazyColumn(
                modifier = Modifier.padding(
                    start = SafeArea.current.value.calculateStartPadding(LayoutDirection.Ltr),
                    top = SafeArea.current.value.calculateTopPadding()
                )
            ) {
                items(Screens.values().size) {
                    val item = Screens.values()[it]
                    ListItem(
                        text = { Text(item.toString()) },
                        modifier = Modifier.clickable {
                            navigator.navigate(route = item.toString())
                            scope.launch { scaffoldState.drawerState.close() }
                        }
                    )
                    Divider()
                }
            }
        },
        scaffoldState = scaffoldState
    ) {
        NavHost(navigator = navigator, initialRoute = Screens.News.toString()) {
            Screens.values().forEach { screen ->
                scene(screen.toString()) {
                    Box(
                        modifier = Modifier.padding(
                            start = SafeArea.current.value.calculateStartPadding(LayoutDirection.Ltr),
                            end = SafeArea.current.value.calculateEndPadding(LayoutDirection.Ltr),
                            bottom = SafeArea.current.value.calculateBottomPadding()
                        )
                    ) {
                        when (screen) {
                            Screens.News -> openArticlesList()
                            Screens.Settings -> Settings()
                        }
                    }
                }
            }
        }
    }
}

enum class Screens {
    News,
    Settings,
}