package com.pasichnyi.cleanarchitecturekmm.data.datasource.remote

import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticle
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.ktor.client.call.*
import io.ktor.client.request.*

class RemoteArticlesDatasource {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    @Throws(Exception::class)
    suspend fun getAll(): List<DataArticle> {
        return httpClient.get("https://newsapi.org/v2/top-headlines?language=en&apiKey=01dfa608af1248fa9569714e81fdd998").body();
    }
}