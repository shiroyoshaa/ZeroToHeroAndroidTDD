package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.transition.ChangeTransform

interface ListLiveDataWrapper {

    fun update(list: List<CharSequence>)
    fun save(bundle: BundleWrapper.Save)
    fun add(new: CharSequence)
    fun liveData(): LiveData<List<CharSequence>>

    class Base(private val liveData: MutableLiveData<ArrayList<CharSequence>> = SingleLiveEvent()
    ): ListLiveDataWrapper {
        override fun update(list: List<CharSequence>) {
            liveData.value = ArrayList(list)
        }

        override fun save(bundle: BundleWrapper.Save) {
            liveData.value?.let {
                bundle.save(it)
            }
        }

        override fun add(new: CharSequence) {
            val currentList = liveData.value?: ArrayList()
            currentList.add(new)
            Log.e("fatal",currentList.toString())
            update(currentList)
        }

        override fun liveData(): LiveData<List<CharSequence>> {
            return liveData.map { it.toList() }
        }
    }
}