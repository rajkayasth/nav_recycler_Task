package com.example.nav_recycler_task.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "f9b76813141b49d8831a879d6f2fa7c5"

class RetroFitClient {
    companion object {
        private var instance: Api? = null
        private var retroFitInstance: Retrofit? = null


        private fun retroInstance(): Retrofit {

            val headerInterceptor = Interceptor { chain ->
                var request = chain.request()
                request = request.newBuilder()
                    .addHeader("apikey", API_KEY)
                    .build()

                chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60L,TimeUnit.SECONDS)
                .writeTimeout(60L,TimeUnit.SECONDS)
                .connectTimeout(60L,TimeUnit.SECONDS)
                .addInterceptor(headerInterceptor)
                .build()

            if (retroFitInstance == null) {
                return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .build()
            }
            return retroFitInstance as Retrofit
        }

        @Synchronized
        fun getInstance(): Api {
            // Log.d("WebAccess", "Creating retrofit client")
            if (instance == null) {

                instance = retroInstance().create(Api::class.java)
            }
            // Log.d("WebAccess", getInstance().toString())
            return instance as Api

        }
    }
}