package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.SavedStateHandle


interface BundleWrapper {

    interface Save {
        fun save(Uistate: UiState)

        class Base(private val savedStateHandle: Bundle): Save {
            companion object {
                private const val KEY = "KEY"
            }
            override fun save(Uistate:UiState) {
                Log.e("save process","saving")
                savedStateHandle.putSerializable("KEY",Uistate)
            }
        }
    }


    interface Restore {
        fun restore(): UiState
        class Base(private val savedStateHandle: Bundle): Restore {
            override fun restore(): UiState {
                Log.e("save process", "onRestore")
                return savedStateHandle.getSerializable("KEY") as UiState

            }
        }
    }

    interface Mutable: Save, Restore

}
