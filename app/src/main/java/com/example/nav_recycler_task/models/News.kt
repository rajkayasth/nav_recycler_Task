package com.example.nav_recycler_task.models

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)