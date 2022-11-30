package com.pasichnyi.cleanarchitecturekmm.di

import com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.cache.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DatabaseDriverFactory(get()) }
}