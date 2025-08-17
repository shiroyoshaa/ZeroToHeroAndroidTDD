package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.ViewModel

interface ViewModelFactory: ProvideViewModel {

    fun <T : ViewModel> clear(viewModelClass: Class<T>): T?

    class Base(private val provideViewModel: ProvideViewModel): ViewModelFactory {
        private val list = mutableMapOf<Class<out ViewModel>, ViewModel>()
        override fun <T : ViewModel> clear(viewModelClass: Class<T>): T? {
            val value = list.remove(viewModelClass)
            return value as T
        }
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {

            if(list.containsKey(viewModelClass)) {
                val value = list.get(viewModelClass)
                return value as T
            } else  {
                val value = list.getOrPut(viewModelClass) {
                    provideViewModel.viewModel(viewModelClass)
                }
                return value as T
            }
        }
    }
}