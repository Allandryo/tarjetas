package com.example.tarjetas

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform