package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory: ClearViewModel, ProvideViewModel{


    class Base(private val provideViewModel : ProvideViewModel): ViewModelFactory {
        private val map = mutableMapOf<Class <out ViewModel>, ViewModel>()


        override fun clearViewModel(clasz: Class<out ViewModel>) {
            map.remove(clasz)
        }
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return if (map.containsKey(viewModelClass))
                map[viewModelClass] as T
            else {
                val viewModel = provideViewModel.viewModel(viewModelClass)
                map[viewModelClass] = viewModel
                viewModel
            }
        }
    }
}