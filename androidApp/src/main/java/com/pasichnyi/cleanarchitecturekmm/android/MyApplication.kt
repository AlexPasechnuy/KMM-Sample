package com.pasichnyi.cleanarchitecturekmm.android

import android.app.Application
import com.pasichnyi.cleanarchitecturekmm.di.commonModule
import com.pasichnyi.cleanarchitecturekmm.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class MyApplication  : Application() {

    override fun onCreate() {
        super.onCreate()

//        startKoin {
//            modules(
//                platformModule()
//                        androidContext(this@YourApp)
//            )
//        }
        startKoin(
            koinApplication{
                androidContext(this@MyApplication)
                modules(
                    commonModule(),
                    platformModule(),
                )
            }
        )
    }
}