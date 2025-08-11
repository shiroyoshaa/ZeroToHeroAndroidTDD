package ru.easycode.zerotoheroandroidtdd

import java.io.Serializable

interface UiState: Serializable{


    object ShowProgress : UiState {

    }

    data class ShowData(private val text:String) : UiState {

    }
}