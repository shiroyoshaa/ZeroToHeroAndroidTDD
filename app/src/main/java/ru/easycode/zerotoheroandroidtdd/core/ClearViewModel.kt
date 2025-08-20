package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import ru.easycode.zerotoheroandroidtdd.main.ViewModelFactory

interface ClearViewModel {
    fun clear(viewModelClass: Class<out ViewModel>)
    class Base: ClearViewModel {
        override fun clear(viewModelClass: Class<out ViewModel>) {
        }
    }
}