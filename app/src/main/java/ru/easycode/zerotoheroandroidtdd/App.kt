package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App: Application() {
    val viewModel = MainViewModel(ListLiveDataWrapper.Base())
    override fun onCreate() {
        super.onCreate()
    }
}