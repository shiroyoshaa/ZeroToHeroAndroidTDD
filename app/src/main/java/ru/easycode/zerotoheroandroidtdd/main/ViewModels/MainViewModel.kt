package ru.easycode.zerotoheroandroidtdd.main.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation

class MainViewModel(private val navigation: Navigation.Mutable): ViewModel() {
    fun liveData() = navigation.liveData()
    fun init(firstRun: Boolean) {
        Log.d("fatal","init in mainViewModel")
        if (firstRun)
            navigation.update(ListScreen)
    }
}