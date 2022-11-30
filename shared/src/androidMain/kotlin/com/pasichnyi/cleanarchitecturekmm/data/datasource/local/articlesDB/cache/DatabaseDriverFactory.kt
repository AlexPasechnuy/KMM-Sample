package com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.cache

import android.content.Context
import com.pasichnyi.cleanarchitecturekmm.shared.cache.AppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.java.KoinJavaComponent.inject

actual class DatabaseDriverFactory(private val context: Context) {
    
    actual fun createDriver(): SqlDriver {

        return AndroidSqliteDriver(AppDatabase.Schema, context, "test.db")
    }
}