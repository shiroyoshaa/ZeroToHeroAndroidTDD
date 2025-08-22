package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.MainViewModel

interface ProvideViewModel {
    fun <T: ViewModel> viewModel(viewModelClass: Class<T>): T
    class Base(private val clearViewModel: ClearViewModel): ProvideViewModel {
        private val navigation = Navigation.Base()
        private val sharedLiveData = ListLiveDataWrapper.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            Log.d("fatal","fun from provideViewModel - $viewModelClass")
            return when(viewModelClass){
                MainViewModel::class.java -> MainViewModel(navigation)
                ListViewModel:: class.java -> ListViewModel(sharedLiveData,navigation)
                CreateViewModel::class.java -> CreateViewModel(sharedLiveData,navigation,clearViewModel)
                else -> throw IllegalStateException()
            } as T
        }
    }
}