package com.pasichnyi.cleanarchitecturekmm.di

import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

fun initKoin() {
    startKoin(
        koinApplication {
            modules(
                commonModule(),
                platformModule(),
            )
        }
    )
}