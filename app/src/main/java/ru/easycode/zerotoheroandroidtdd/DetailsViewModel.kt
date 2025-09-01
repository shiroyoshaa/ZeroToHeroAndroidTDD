package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel(private val changeLiveDataWrapper: ListLiveDataWrapper.All,
    private val repository: Repository.Change,
    private val clear: ClearViewModel,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main,
    ): ViewModel() {

        private val innerLiveData = MutableLiveData<String>()

    val liveData: LiveData<String>
        get() = innerLiveData

    fun init(itemId: Long) {
        viewModelScope.launch(dispatcher) {
            val itemText = repository.item(itemId).text
            withContext(dispatcherMain) {
                innerLiveData.value = itemText
            }
        }
    }

    fun delete(itemId: Long) {
        viewModelScope.launch(dispatcher) {
            val item = repository.item(id = itemId)
            repository.delete(itemId)
            val itemUi = ItemUi(id = item.id,text = item.text)
            withContext(dispatcherMain) {
                changeLiveDataWrapper.delete(itemUi)
            }
        }
        comeback()
    }

    fun update(itemId: Long, newText: String) {
        viewModelScope.launch(dispatcher) {
            repository.update(itemId,newText)
            val itemUi = ItemUi(id = itemId,text = newText)
            withContext(dispatcherMain) {
                changeLiveDataWrapper.update(item = itemUi)
            }
        }
        comeback()
    }


    fun comeback() {
        clear.clearViewModel(DetailsViewModel::class.java)
    }
}