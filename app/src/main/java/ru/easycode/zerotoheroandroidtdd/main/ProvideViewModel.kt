package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.ViewModel

interface ProvideViewModel {
    fun <T: ViewModel> viewModel(viewModelClass: Class<T>): T
    class Base: ProvideViewModel {
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return viewModel(viewModelClass)
        }
    }
}