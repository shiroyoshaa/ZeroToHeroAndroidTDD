package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.LiveData

interface LiveDataWrapper {
    fun update(value: UiState) {
    }
    fun liveData(): LiveData<UiState>
}