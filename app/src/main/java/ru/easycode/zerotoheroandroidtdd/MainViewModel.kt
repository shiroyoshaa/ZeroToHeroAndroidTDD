package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val liveDataWrapper: LiveDataWrapper,private val repository: Repository): ViewModel() {
    fun load() {
        viewModelScope.launch {
            liveDataWrapper.update(UiState.ShowProgress)
            repository.load()
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {

    }
    fun restore(bundleWrapper: BundleWrapper.Restore) {

    }

}