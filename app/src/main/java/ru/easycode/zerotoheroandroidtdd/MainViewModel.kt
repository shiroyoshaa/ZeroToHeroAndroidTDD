package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(private val listLiveDataWrapper: ListLiveDataWrapper): ViewModel() {

    fun liveData() = listLiveDataWrapper.liveData()

    fun add(text: String) {
        Log.e("testingAdapter","fun add in viewModel - ${text.toString()}")
        listLiveDataWrapper.add(text)
    }
    fun save(bundle: BundleWrapper.Save) {
        listLiveDataWrapper.save(bundle)
    }
    fun restore(bundle: BundleWrapper.Restore) {
        val list = bundle.restore()
        listLiveDataWrapper.update(list)
    }
}