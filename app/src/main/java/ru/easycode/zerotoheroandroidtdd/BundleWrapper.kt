package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle

interface BundleWrapper {


    interface Save {
        fun save(uiState: UiState)
    }


    interface Restore {
        fun restore(): UiState
    }
    interface Mutable: Save, Restore

    class Base(private val savingState: Bundle): Save, Restore {
        companion object {
            private const val KEY = "KEY"
        }
        override fun save(uiState: UiState) {
            savingState.putSerializable("KEY",uiState::class.java)
        }

        override fun restore(): UiState {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                savingState.getSerializable("KEY",UiState::class.java) as UiState
            } else {
                TODO("VERSION.SDK_INT < TIRAMISU")
            }
        }
    }
}