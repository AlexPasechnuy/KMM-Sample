package com.pasichnyi.cleanarchitecturekmm.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.pasichnyi.cleanarchitecturekmm.presentation.root.DefaultRootComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.root.NewRootContent
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController =
    Application("News") {
        Column {
            Box(
                modifier = Modifier
                    .height(50.dp)
            )
            NewRootContent(
                component = DefaultRootComponent(
                    componentContext = DefaultComponentContext(LifecycleRegistry()),
                ), modifier = Modifier.fillMaxSize()
            )
        }
    }