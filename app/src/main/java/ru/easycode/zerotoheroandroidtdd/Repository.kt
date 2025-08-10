package ru.easycode.zerotoheroandroidtdd

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Repository {

    suspend fun load(): SimpleResponse

    class Base(private var service: SimpleService, private val url: String): Repository {
        override suspend fun load(): SimpleResponse {
            val response = service.fetch(url)
            return response
        }
    }
}