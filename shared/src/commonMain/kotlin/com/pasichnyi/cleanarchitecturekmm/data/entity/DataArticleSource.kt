package com.pasichnyi.cleanarchitecturekmm.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class DataArticleSource(
    val name: String = "Unknown",
)