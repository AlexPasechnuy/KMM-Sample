package com.pasichnyi.cleanarchitecturekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform