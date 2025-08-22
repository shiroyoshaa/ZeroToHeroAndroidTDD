package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import androidx.lifecycle.ViewModel

interface ViewModelFactory: ProvideViewModel,ClearViewModel {


    class Base(private val provideViewModel: ProvideViewModel): ViewModelFactory {

        private val list = mutableMapOf<Class<out ViewModel>, ViewModel>() //MainViewModel::class.java its key, its value - MainViewModel

        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return if(list.containsKey(viewModelClass)) {
                list[viewModelClass] as T
            } else {
                val viewModel = provideViewModel.viewModel(viewModelClass)
                list[viewModelClass] = viewModel
                Log.d("fatal","else in factory $viewModel")
                viewModel
            }
        }
        override fun clear(viewModelClass: Class<out ViewModel>) {
           list.remove(viewModelClass)
        }
    }
}
