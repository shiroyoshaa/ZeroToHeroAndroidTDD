package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val liveDataWrapper: LiveDataWrapper,private val repository: Repository): ViewModel() {

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        viewModelScope.launch {
            liveDataWrapper.update(UiState.ShowProgress)
            val txt = repository.load()
            liveDataWrapper.update(UiState.ShowData(txt.text))
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }
    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val state = bundleWrapper.restore()
        liveDataWrapper.update(state)
    }

}