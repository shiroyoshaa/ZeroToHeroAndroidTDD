package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.create.CreateScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen



class ListViewModel(private val liveDataWrapper: ListLiveDataWrapper.Mutable,
                    private val navigation: Navigation.Update): ViewModel() {

    fun create() {
        navigation.update(CreateScreen)
    }

    fun liveData() = liveDataWrapper.read()

    fun save(bundleWrapper:BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }
    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val newList = bundleWrapper.restore()
        liveDataWrapper.update(newList
        )
    }
}