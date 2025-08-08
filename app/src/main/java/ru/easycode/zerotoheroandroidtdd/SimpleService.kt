package ru.easycode.zerotoheroandroidtdd

interface SimpleService {
    suspend fun fetch(url: String): SimpleResponse

    class Base(private val simpleResponse: SimpleResponse): SimpleService {
        override suspend fun fetch(url: String): SimpleResponse {
            return simpleResponse
        }
    }
}