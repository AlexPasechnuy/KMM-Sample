package com.pasichnyi.cleanarchitecturekmm.android.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.arkivanov.decompose.defaultComponentContext
import com.pasichnyi.cleanarchitecturekmm.MainView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContent {
//            MainView()
//        }

        setContent {
            MaterialTheme {
                Surface {
                    MainView(context = defaultComponentContext())
                }
            }
        }
    }
}