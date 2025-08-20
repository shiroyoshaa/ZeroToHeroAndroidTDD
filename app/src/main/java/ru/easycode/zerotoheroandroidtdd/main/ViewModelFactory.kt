package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel

interface ViewModelFactory: ProvideViewModel,ClearViewModel {


    class Base(private val provideViewModel: ProvideViewModel): ViewModelFactory {

        private val list = mutableMapOf<Class<out ViewModel>, ViewModel>()

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

        override fun clear(viewModelClass: Class<out ViewModel>) {
           list.remove(viewModelClass)
        }
    }
}