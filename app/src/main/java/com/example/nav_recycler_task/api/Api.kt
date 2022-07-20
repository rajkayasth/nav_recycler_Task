package com.example.nav_recycler_task.api

import com.example.nav_recycler_task.models.News
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadline(@Query("country") country: String, @Query("page") page: Int): Call<News>

}