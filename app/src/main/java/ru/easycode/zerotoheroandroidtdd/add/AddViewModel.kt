package ru.easycode.zerotoheroandroidtdd.add

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemUi
import ru.easycode.zerotoheroandroidtdd.core.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.core.Repository

class AddViewModel(private val repository: Repository.Add,
                   private val liveDataWrapper: ListLiveDataWrapper.Add
,                   private val clear: ClearViewModel,
                    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
                   private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main,
): ViewModel() {

    fun add(value: String) {
        viewModelScope.launch(dispatcher) {
            val longValue = repository.add(value)
            liveDataWrapper.add(ItemUi(id = longValue,text = value))

        }
        comeback()
    }
    fun comeback() {
        clear.clearViewModel(AddViewModel::class.java)
    }
}