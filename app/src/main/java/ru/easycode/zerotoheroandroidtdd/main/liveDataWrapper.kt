package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import ru.easycode.zerotoheroandroidtdd.core.SingleLiveEvent

interface ListLiveDataWrapper {
    interface Add {
        fun add(source: CharSequence)
    }
    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }
    interface LiveData {
        fun liveData(): androidx.lifecycle.LiveData<List<CharSequence>>
    }
    interface Update{
        fun update(value: List<CharSequence>)
    }
    interface Mutable: Add,Save, ListLiveDataWrapper.LiveData, Update
    interface All: Mutable
    class Base(private val liveData: MutableLiveData<ArrayList<CharSequence>> = SingleLiveEvent()): All {
        override fun add(source: CharSequence) {

        }

        override fun save(bundleWrapper: BundleWrapper.Save) {
           liveData.value?.let {
               bundleWrapper.save(it)
           }
        }

        override fun liveData(): androidx.lifecycle.LiveData<List<CharSequence>> {
                 return liveData.map { it.toList() }
        }

        override fun update(value: List<CharSequence>) {
          liveData.value = ArrayList(value)
        }

    }
}
