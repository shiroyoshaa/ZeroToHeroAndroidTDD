package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.easycode.zerotoheroandroidtdd.core.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.core.Repository

class MainViewModel(private val repository: Repository.Read
,private val liveDataWrapper: ListLiveDataWrapper.Mutable
,private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main,
): ViewModel(){

    fun init() {
        viewModelScope.launch(dispatcher) {
                val value = repository.list()
                liveDataWrapper.update(value)
            }
    }
    fun liveData() = liveDataWrapper.liveData()

}