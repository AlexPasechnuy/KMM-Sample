package com.pasichnyi.cleanarchitecturekmm.data.datasource.remote

import com.pasichnyi.cleanarchitecturekmm.data.entity.ArticlesApiResponse
import com.pasichnyi.cleanarchitecturekmm.data.entity.DataArticle
import com.pasichnyi.cleanarchitecturekmm.exception.OfflineException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.logging.*
import kotlinx.serialization.json.Json

class RemoteArticlesDatasource {

    private val httpClient by lazy {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    @Throws(Exception::class)
    suspend fun getAll(): List<DataArticle> {
        return try {
            val response =
                httpClient.get("https://newsapi.org/v2/top-headlines?language=en&sortBy=publishedAt&apiKey=01dfa608af1248fa9569714e81fdd998")
            val responseBody: ArticlesApiResponse = response.body()
            responseBody.articles
        } catch (ex: Exception) {
            ex.printStackTrace()
            throw OfflineException()
        }
    }
}