package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.UnknownHostException

interface Repository {
    suspend fun load(): LoadResult

    class Base(private var service: SimpleService

    ,private val url: String): Repository {

        override suspend fun load(): LoadResult {
            try {
                val simple = service.fetch(url)
                return LoadResult.Success(simple)
            } catch (e: UnknownHostException) {
                return LoadResult.Error(true)
            } catch (e: IllegalStateException) {
                return LoadResult.Error(false)
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
