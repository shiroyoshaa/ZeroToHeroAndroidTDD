package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import javax.inject.Inject

class LiveDataWrapperClass @Inject constructor(): LiveDataWrapper {
    override fun update(value: UiState) {
        super.update(value)
    }

    override fun liveData(): LiveData<UiState> {
        TODO("Not yet implemented")
    }
}