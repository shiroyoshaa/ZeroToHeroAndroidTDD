package ru.easycode.zerotoheroandroidtdd

import android.widget.ProgressBar

interface UiState {
    object ShowProgress : UiState {

    }
    object ShowData: UiState {

    }
}