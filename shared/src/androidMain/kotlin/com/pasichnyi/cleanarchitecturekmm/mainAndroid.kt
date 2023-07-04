package com.pasichnyi.cleanarchitecturekmm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.DefaultComponentContext
import com.pasichnyi.cleanarchitecturekmm.presentation.root.DefaultRootComponent
import com.pasichnyi.cleanarchitecturekmm.presentation.root.NewRootContent

@Composable
fun MainView(context: DefaultComponentContext) = NewRootContent(
    component = DefaultRootComponent(
        componentContext = context,
    ), modifier = Modifier.fillMaxSize()
)