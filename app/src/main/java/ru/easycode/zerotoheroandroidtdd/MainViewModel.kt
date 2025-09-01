package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val liveDataWrapper: ListLiveDataWrapper.All,
    private val repository: Repository.Read,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main,
): ViewModel() {

    fun init() {

        viewModelScope.launch(dispatcher) {
            val item = repository.list()
            val itemUi = item.map { ItemUi(
                id = it.id,
                text = it.text
            ) }
            withContext(dispatcherMain) {
                liveDataWrapper.update( list = itemUi)
            }
        }
    }

    fun liveData() = liveDataWrapper.liveData()
}