package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemUi
import ru.easycode.zerotoheroandroidtdd.core.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.core.Repository

class MainViewModel(private val repository: Repository.Read,
                    private val liveDataWrapper: ListLiveDataWrapper.All,
                    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
                    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main

): ViewModel() {

    fun init() {
        viewModelScope.launch(dispatcher) {
            val value = repository.list()
            val list: List<ItemUi> = value.map {
            ItemUi(
                id = it.id,
                text = it.text,
            )
        }
            liveDataWrapper.update(list)
        }
    }
    fun liveData() = liveDataWrapper.liveData()
}