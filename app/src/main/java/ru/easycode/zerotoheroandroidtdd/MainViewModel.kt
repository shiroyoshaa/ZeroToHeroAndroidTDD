package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val liveDataWrapper: LiveDataWrapper, private val repository: Repository): ViewModel() {


    fun liveData() = liveDataWrapper.liveData()
    fun load() {
        viewModelScope.launch {
            liveDataWrapper.update(UiState.ShowProgress)
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }
    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)

    }
   fun restore(bundleWrapper: BundleWrapper.Restore) {
       liveDataWrapper.update(bundleWrapper.restore())
   }
}