package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.ViewModel

interface ViewModelFactory: ProvideViewModel {

    fun <T : ViewModel> clear(viewModelClass: Class<T>): T?

    class Base(private val provideViewModel: ProvideViewModel): ViewModelFactory {
        private val list = mutableMapOf<Class<out ViewModel>, ViewModel>()
        override fun <T : ViewModel> clear(viewModelClass: Class<T>): T? {
            return null
        }
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            list.add(viewModelClass)
            list.getOrP
        }
    }
}