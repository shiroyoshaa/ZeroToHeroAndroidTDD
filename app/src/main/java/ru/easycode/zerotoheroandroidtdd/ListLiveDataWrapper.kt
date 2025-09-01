package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import java.io.Serializable

interface ListLiveDataWrapper {

    interface Delete {
        fun delete(item: ItemUi)
    }
    interface Read {
        fun liveData(): LiveData<List<ItemUi>>
    }
    interface Add {
        fun add(value: ItemUi)
    }
    interface Update {
        fun update(list: List<ItemUi>)
    }
    interface UpdateValue {
        fun update(item: ItemUi)
    }

    interface Mutable: Delete, Read, Update
    interface All: Mutable, Add, UpdateValue

    class Base(private val liveData: MutableLiveData<ArrayList<ItemUi>> = MutableLiveData()): All {

        override fun delete(item: ItemUi) {
            Log.d("fatal","before delete ${liveData.value}")
            val currentList = liveData.value
            currentList?.remove(item)
            update(ArrayList(currentList))
            Log.d("fatal","after delete ${liveData.value}")
        }

        override fun liveData(): LiveData<List<ItemUi>> {
            return liveData.map { it.toList() }
        }

        override fun update(list: List<ItemUi>) {
            liveData.value = ArrayList(list)
        }

        override fun update(item: ItemUi) {
            val currentList = liveData.value
            currentList!!.find { it.areItemsSame(item) }?.let {
                currentList[currentList.indexOf(it)] = item
            }
            Log.d("fatal","currentList in update $currentList")
            update(currentList)
        }

        override fun add(value: ItemUi) {
            val currentList = liveData.value?: ArrayList()
            currentList.add(value)
            Log.d("fatal",currentList.toString())
            update(currentList)
        }
    }
}

data class ItemUi(
    val id: Long,
    val text: String

): Serializable {

    fun areItemsSame(item: ItemUi): Boolean =  id == item.id

    fun delete(deleteItemUi: DeleteItemUi,item: ItemUi) = deleteItemUi.delete(itemUi = item)

    fun setTextTextView(elementTextView: TextView) = elementTextView.setText(text)


}