package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.LiveData

interface LiveDataWrapper {
    fun update(value: UiState) {
        Log.e("testing process","liveDataWrapper")
    }
    fun liveData(): LiveData<UiState>
}