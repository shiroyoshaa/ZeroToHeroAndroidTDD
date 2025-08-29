package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemUi

interface ListLiveDataWrapper {
    interface Update {
        fun update(value: List<ItemUi>)
    }

    interface LiveData {
        fun liveData(): androidx.lifecycle.LiveData<List<ItemUi>>
    }
    interface Add {
        fun add(value: ItemUi)
    }
    interface Delete {
        fun delete(item: ItemUi)
    }
    interface Mutable: Update, LiveData,Delete

    interface All: Mutable, Add
    class Base(private val liveData: MutableLiveData<List<ItemUi>> = MutableLiveData()): All {
        override fun update(value: List<ItemUi>) {
            liveData.postValue(value)
        }

        override fun liveData(): androidx.lifecycle.LiveData<List<ItemUi>> {
            return liveData.map { it.toList() }
        }

        override fun delete(item: ItemUi) {
            val currenList = liveData.value?: ArrayList()
            val newList = ArrayList(currenList)
            newList.remove(item)
            update(newList)
        }

        override fun add(value: ItemUi) {
            val currentList = liveData.value?: ArrayList()
            val newList = ArrayList(currentList)
            newList.add(value)
            update(newList)
        }
    }
}