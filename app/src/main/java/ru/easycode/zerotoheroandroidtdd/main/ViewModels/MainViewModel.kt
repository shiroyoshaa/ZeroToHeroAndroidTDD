package ru.easycode.zerotoheroandroidtdd.main.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListScreen
import ru.easycode.zerotoheroandroidtdd.list.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen

class MainViewModel(private val navigation: Navigation.Mutable): ViewModel() {
    fun init(firstRun: Boolean) {
        if (firstRun)
            navigation.update(ListScreen)
    }

    fun liveData(): LiveData<Screen> = navigation.read()




}