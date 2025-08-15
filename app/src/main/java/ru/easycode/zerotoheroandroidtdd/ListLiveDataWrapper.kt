package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map

interface ListLiveDataWrapper {
    fun add(new: CharSequence)
    fun save(bundle: BundleWrapper.Save)
    fun update(list: List<CharSequence>)
    fun liveData(): LiveData<List<CharSequence>>
    class Base(private val liveData: MutableLiveData<ArrayList<CharSequence>> = SingleLiveEvent()): ListLiveDataWrapper {
        override fun add(new: CharSequence) {
            var currentList = liveData.value ?: ArrayList()
            Log.d("listLiveData",currentList.toString())
            currentList.add(new)
            val list: List<CharSequence> = currentList!!

            update(list)
        }
        override fun save(bundle: BundleWrapper.Save) {
            liveData.value?.let {
                bundle.save(it)
            }
        }

        override fun update(list: List<CharSequence>) {
            liveData.value = ArrayList(list)
        }

        override fun liveData(): LiveData<List<CharSequence>> {
            return liveData.map { it.toList() }
        }

    }
}