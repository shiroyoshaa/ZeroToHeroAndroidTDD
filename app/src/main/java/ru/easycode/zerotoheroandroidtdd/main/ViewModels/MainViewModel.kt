package ru.easycode.zerotoheroandroidtdd.main.ViewModels

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation

class MainViewModel(private val navigation: Navigation.Mutable): ViewModel() {
    fun init(firstRun: Boolean) {
        if (firstRun)
            navigation.update(ListScreen)
    }
}