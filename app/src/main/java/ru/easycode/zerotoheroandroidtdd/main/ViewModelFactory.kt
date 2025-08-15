package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.ViewModel

interface ViewModelFactory: ProvideViewModel {

    fun <T : ViewModel> clear(viewModelClass: Class<T>): T

    class Base(private val provideViewModel: ProvideViewModel): ViewModelFactory {

        override fun <T : ViewModel> clear(viewModelClass: Class<T>): T {
            return viewModel(viewModelClass)
        }
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {

            return provideViewModel.viewModel(viewModelClass)
        }

    }
}