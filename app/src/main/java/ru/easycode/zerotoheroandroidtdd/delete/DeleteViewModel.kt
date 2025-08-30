package ru.easycode.zerotoheroandroidtdd.delete

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemUi
import ru.easycode.zerotoheroandroidtdd.core.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.core.Repository

class DeleteViewModel(private val deleteLiveDataWrapper: ListLiveDataWrapper.All
,private val repository: Repository.Delete,private val clear: ClearViewModel
,private  val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main,
): ViewModel() {

    private val innerliveData = MutableLiveData<String>()


    val liveData: LiveData<String>
        get() = innerliveData


    fun init(itemId: Long) {
        viewModelScope.launch(dispatcher) {
            val itemText = repository.item(itemId).text
            withContext(dispatcherMain) {
                innerliveData.value = itemText
            }
        }
    }

    fun delete(itemId: Long) {
        viewModelScope.launch(dispatcher) {
            val itemNow = repository.item(itemId)
            repository.delete(itemId)
            deleteLiveDataWrapper.delete(ItemUi(id = itemNow.id,text = itemNow.text))
        }
        comeback()
    }

    fun comeback() {
        clear.clearViewModel(DeleteViewModel::class.java)
    }
}