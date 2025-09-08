package ru.easycode.zerotoheroandroidtdd.main

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.folder.list.FoldersListScreen


class MainViewModel(private val navigation: Navigation.Mutable): ViewModel() {

    fun init(firstRun: Boolean) {
        if (firstRun){
                navigation.update(FoldersListScreen)
            }
    }
    fun livedata() = navigation.liveData()
}