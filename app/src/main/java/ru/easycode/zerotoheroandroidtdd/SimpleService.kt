package ru.easycode.zerotoheroandroidtdd

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface SimpleService {

    @GET
    suspend fun fetch(@Url url: String): SimpleResponse

}

data class SimpleResponse (
    var text: String,
)