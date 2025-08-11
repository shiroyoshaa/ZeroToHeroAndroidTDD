package ru.easycode.zerotoheroandroidtdd

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

interface Repository {
    suspend fun load(): LoadResult
    class Base(private var service: SimpleService
    ,private val url: String): Repository {
        override suspend fun load(): LoadResult {
            service = retrofit.create(SimpleService::class.java)
            val simple = service.fetch(url)
            try {
                return LoadResult.Success(simple)
            } catch (e: IOException) {
                return LoadResult.Error(true)
            }
        }
    }
}

interface LoadResult {

    fun show(updateLiveData: LiveDataWrapper.Update)

    data class Success(private val data: SimpleResponse): LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(data.text))
        }

    }
    data class Error(private val noConnection: Boolean): LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            if(noConnection) {
                updateLiveData.update(UiState.ShowData("No internet connection"))
            } else {
                updateLiveData.update(UiState.ShowData("Something went wrong"))
            }
        }
    }
}
val retrofit = Retrofit.Builder()
    .baseUrl("https://www.google.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()