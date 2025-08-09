package ru.easycode.zerotoheroandroidtdd

import java.io.Serializable

interface UiState : Serializable {


    object ShowProgress: UiState {}

    class ShowData(private val text: String): UiState {

    }
}