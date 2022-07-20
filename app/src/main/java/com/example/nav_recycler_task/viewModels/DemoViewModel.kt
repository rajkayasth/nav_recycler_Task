package com.example.nav_recycler_task.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nav_recycler_task.models.News
import com.example.nav_recycler_task.respository.NewsRespository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemoViewModel(private val respository: NewsRespository) : ViewModel() {

    private val quoteLiveData = MutableLiveData<News>()

    val quotes: LiveData<News> = quoteLiveData

    fun setHeadline(country: String, page: Int) {
        val result = respository.getHeadline(country, page)
        result.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                //Log.e("result",response.body().toString())
                quoteLiveData.value = response.body()
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("Error", "${t.message}", t)
            }

        })
    }

}