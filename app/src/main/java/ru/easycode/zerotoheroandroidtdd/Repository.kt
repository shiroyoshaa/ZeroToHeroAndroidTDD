package ru.easycode.zerotoheroandroidtdd

interface Repository {
    suspend fun load(): SimpleResponse
    class Base(private val service: service, url: String): Repository {
        override suspend fun load(): SimpleResponse {

        }
    }
}