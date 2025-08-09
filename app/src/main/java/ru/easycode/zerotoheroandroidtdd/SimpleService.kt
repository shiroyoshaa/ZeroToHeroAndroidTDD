package ru.easycode.zerotoheroandroidtdd

import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleService {

    suspend fun fetch(url: String): SimpleResponse

    class Base: SimpleService {
        @GET
        override suspend fun fetch(url: String): SimpleResponse {

        }
    }
}