package com.example.nav_recycler_task.respository

import com.example.nav_recycler_task.api.Api

class NewsRespository(private val apiService : Api) {
    fun getHeadline(country:String,page:Int) = apiService.getHeadline(country, page)
}