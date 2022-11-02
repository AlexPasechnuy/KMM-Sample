package com.pasichnyi.cleanarchitecturekmm.data.repository

import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

interface ArticlesRepository {

    suspend fun getAll() : List<Article>;
}