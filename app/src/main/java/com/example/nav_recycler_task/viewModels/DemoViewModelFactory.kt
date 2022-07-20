package com.example.nav_recycler_task.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nav_recycler_task.respository.NewsRespository

class DemoViewModelFactory(private val respository: NewsRespository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DemoViewModel(respository) as T
    }

}