package com.pasichnyi.cleanarchitecturekmm.view

import RootView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController =
    Application("Todo") {
        Column {
            Box(
                modifier = Modifier
                    .height(50.dp)
            )
            RootView()
        }
    }