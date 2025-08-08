package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel

class MainViewModel(private val liveDataWrapper: LiveDataWrapper,private val repository: Repository): ViewModel() {
    fun load() {

    }

    fun save(bundleWrapper: BundleWrapper.Save) {

    }
    fun restore(bundleWrapper: BundleWrapper.Restore) {

    }

}