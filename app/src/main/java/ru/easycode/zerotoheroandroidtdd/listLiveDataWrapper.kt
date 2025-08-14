package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.transition.ChangeTransform

interface ListLiveDataWrapper {

    fun update(list: List<CharSequence>)
    fun save(bundle: BundleWrapper.Save)
    fun add(new: CharSequence)
    fun liveData(): LiveData<List<CharSequence>>

    class Base(private val adapter: TvAdapter,private val liveData: MutableLiveData<List<CharSequence>> = SingleLiveEvent()): ListLiveDataWrapper {
        override fun update(list: List<CharSequence>) {
            liveData.value = list
        }

        override fun save(bundle: BundleWrapper.Save) {
            bundle.save(adapter.getValueFromList())
        }

        override fun add(new: CharSequence) {
            adapter.addExample(new)
        }

        override fun liveData(): LiveData<List<CharSequence>> {
            return liveData
        }
    }
}