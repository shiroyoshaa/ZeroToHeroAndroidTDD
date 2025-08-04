package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var liveDataWrapper: LiveDataWrapper, var repository: Repository) : ViewModel() {
    fun load() {
        viewModelScope.launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowProgress)
            liveDataWrapper.update(UiState.ShowData)
        }
    }
}