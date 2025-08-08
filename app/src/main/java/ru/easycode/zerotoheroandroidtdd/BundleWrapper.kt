package ru.easycode.zerotoheroandroidtdd

interface BundleWrapper {

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }
    interface Mutable: Save, Restore

    class Base: Save, Restore {
        override fun save(uiState: UiState) {

        }

        override fun restore(): UiState {
        }
    }
}