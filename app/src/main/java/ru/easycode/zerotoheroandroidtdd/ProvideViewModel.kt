package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import java.lang.IllegalStateException

interface ProvideViewModel {
    fun <T: ViewModel> viewModel(viewModelClass: Class<T>): T
    class Base(private val clear: ClearViewModel, private val itemDao: ItemsDao, private val now: Now): ProvideViewModel {
        private val repository = Repository.Base(dataSource = itemDao,now)
        private val sharedLiveData = ListLiveDataWrapper.Base()
        override  fun <T: ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {
                MainViewModel::class.java -> MainViewModel(sharedLiveData,repository)
                AddViewModel::class.java -> AddViewModel(repository,sharedLiveData,clear)
                DetailsViewModel::class.java -> DetailsViewModel(sharedLiveData,repository,clear)
                else -> throw IllegalStateException()
            } as T
        }
    }
}