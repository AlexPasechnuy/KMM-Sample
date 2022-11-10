package com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.cache

import com.pasichnyi.cleanarchitecturekmm.shared.cache.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "test.db")
    }
}