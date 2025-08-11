package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle

interface BundleWrapper {
    interface Save {
        fun save(uiState: UiState)
    }
    interface Restore  {
        fun restore(): UiState
    }
    interface Mutable: Save, Restore

    class Base(private val savedState: Bundle): Mutable {
        companion object {
            private const val KEY = "KEY"
        }
        override fun save(uiState: UiState) {
            savedState.putSerializable(KEY, uiState)
        }

        override fun restore(): UiState {
           return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
               savedState.getSerializable(KEY, UiState::class.java) as UiState
           } else {
               TODO("VERSION.SDK_INT < TIRAMISU")
           }
        }
    }
}