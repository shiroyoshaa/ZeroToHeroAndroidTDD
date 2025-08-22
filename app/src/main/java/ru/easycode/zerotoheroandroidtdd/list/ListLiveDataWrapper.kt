package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import ru.easycode.zerotoheroandroidtdd.core.SingleLiveEvent
import ru.easycode.zerotoheroandroidtdd.main.Navigation.Mutable
import ru.easycode.zerotoheroandroidtdd.main.Screen

interface ListLiveDataWrapper {
    interface Read: LiveDataWrapper.Read<List<CharSequence>>
    interface Update: LiveDataWrapper.Update<List<CharSequence>>
    interface Mutable: Read,Update {

        fun save(bundleWrapper: BundleWrapper.Save)
    }
    interface Add {
        fun add(source: CharSequence)
    }
    interface All: Mutable,Add

    class Base: LiveDataWrapper.Abstract<List<CharSequence>>(),All {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value.let {
                bundleWrapper.save(ArrayList(it))
            }
        }

        override fun add(source: CharSequence) {
            val currentList = liveData.value?: ArrayList()
            val newList = ArrayList(currentList)
            newList.add(source)
            update(newList)
        }

    }
}

