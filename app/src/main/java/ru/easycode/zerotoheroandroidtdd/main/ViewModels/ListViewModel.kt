package ru.easycode.zerotoheroandroidtdd.main.ViewModels

import ru.easycode.zerotoheroandroidtdd.create.CreateScreen
import ru.easycode.zerotoheroandroidtdd.list.ListScreen
import ru.easycode.zerotoheroandroidtdd.main.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.main.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen

class ListViewModel(private val liveDataWrapper: ListLiveDataWrapper.Mutable,
                    private val navigation: Navigation.Update) {
    fun create() {
        navigation.update(CreateScreen)
    }
    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }
    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val value = bundleWrapper.restore()
        liveDataWrapper.update(value)
    }
}