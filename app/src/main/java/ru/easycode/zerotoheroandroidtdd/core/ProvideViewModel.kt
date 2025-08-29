package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.add.AddViewModel
import ru.easycode.zerotoheroandroidtdd.dataBase.Core
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemsDao
import ru.easycode.zerotoheroandroidtdd.delete.DeleteViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel

interface ProvideViewModel {

    fun <T: ViewModel> viewModel(viewModelClass: Class<T>): T

    class Base(private val core: Core, private val now: Now,private val clear: ClearViewModel): ProvideViewModel{

        private val repository = Repository.Base(dataSource = core.dao(),now)
        private val sharedLiveData = ListLiveDataWrapper.Base()

        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {
                MainViewModel::class.java -> MainViewModel(repository,sharedLiveData)
                AddViewModel::class.java -> AddViewModel(repository,sharedLiveData,clear)
                DeleteViewModel::class.java -> DeleteViewModel(sharedLiveData,repository,clear)
                else -> throw IllegalStateException()
            } as T
        }
    }
}