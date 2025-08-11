package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel

class MainViewModel(private val liveDataWrapper: LiveDataWrapper, private val repository: Repository): ViewModel() {
    suspend fun load() {

        val a = repository.load()

    }
}