package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.LiveData
interface ListLiveDataWrapper {
    interface Update {
        fun update(value: List<String>)
    }
    interface LiveData {
        fun liveData(): androidx.lifecycle.LiveData<List<String>>
    }
    interface Add {
        fun add(value: String)
    }
    interface Mutable: Update, LiveData
    class Base(private val liveData: MutableLiveData<List<String>> = MutableLiveData()): Mutable,Add  {
        override fun update(value: List<String>) {
            liveData.postValue(value)
        }

        override fun liveData(): androidx.lifecycle.LiveData<List<String>> {
            return liveData
        }

        override fun add(value: String) {
            val currentList = liveData.value ?: ArrayList()
            val newList = ArrayList(currentList)
            newList.add(value)
            Log.d("fatal",newList.toString())
            update(newList)
        }
    }
}