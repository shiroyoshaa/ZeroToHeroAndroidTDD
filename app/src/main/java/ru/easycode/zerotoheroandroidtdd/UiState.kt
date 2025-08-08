package ru.easycode.zerotoheroandroidtdd

interface UiState {
    object ShowProgress : UiState {
    }
    companion object {
        fun ShowData(text: String) {

        }
    }
}