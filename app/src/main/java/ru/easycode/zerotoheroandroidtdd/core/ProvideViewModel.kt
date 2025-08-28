package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.add.AddViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel

interface ProvideViewModel {
    fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T

    class Base(private val core: Core,private val clearViewModel: ClearViewModel): ProvideViewModel {
        private val repository = Repository.Base(dataSource = core.dao(),Now.Base())
        private val liveDataWrapper = ListLiveDataWrapper.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {
                MainViewModel::class.java -> MainViewModel(repository,liveDataWrapper)
                AddViewModel:: class.java -> AddViewModel(repository,liveDataWrapper,clearViewModel)
                else -> throw IllegalStateException()
            } as T
        }
    }
}