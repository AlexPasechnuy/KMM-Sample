package com.pasichnyi.cleanarchitecturekmm.android.view

import android.os.Bundle
import com.pasichnyi.cleanarchitecturekmm.view.MainView
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent


class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView()
        }
    }
}