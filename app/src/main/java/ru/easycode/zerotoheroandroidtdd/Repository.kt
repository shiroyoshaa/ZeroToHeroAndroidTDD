package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import kotlinx.coroutines.delay
import kotlin.math.log

interface Repository {

    suspend fun load() {
    }
    class Base: Repository {
        override suspend fun load() {
            delay(3500)
        }
    }
}