package com.pasichnyi.cleanarchitecturekmm.presentation.newssection

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.pasichnyi.cleanarchitecturekmm.presentation.newssection.articledetails.openArticleDetails
import com.pasichnyi.cleanarchitecturekmm.presentation.newssection.newslist.openArticlesList
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun NewsSection() {
    val navigator = rememberNavigator()
    MaterialTheme {
        NavHost(
            navigator = navigator,
            initialRoute = "/list"
        ) {
            scene("/list") {
                openArticlesList{navigator.navigate("/details/${it.url.replace('/','|')}")}
            }
            scene("/details/{url}") { backStackEntry ->
                backStackEntry.path<String>("url")?.let {
                    openArticleDetails(it.replace('|','/'))
                }
            }
        }
    }
}