package com.pasichnyi.cleanarchitecturekmm.data.datasource.local.articlesDB.cache

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}