package com.pasichnyi.cleanarchitecturekmm

import com.pasichnyi.cleanarchitecturekmm.domain.entity.Article

sealed class Screen {
    object List : Screen()
    data class Details(val article: Article) : Screen()
}