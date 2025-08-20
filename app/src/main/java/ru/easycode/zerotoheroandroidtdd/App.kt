package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.MainViewModel

class App: Application() {
    lateinit var mainViewModel: MainViewModel
    lateinit var createViewModel: CreateViewModel
    lateinit var listViewModel: ListViewModel
    val listLiveDataWrap: ListLiveDataWrapper.Mutable = ListLiveDataWrapper.Base()
    val appNavigation: Navigation.Mutable = Navigation.Base()
    override fun onCreate() {
        super.onCreate()
        mainViewModel = MainViewModel(appNavigation)
        listViewModel = ListViewModel(listLiveDataWrap,appNavigation)
        createViewModel = CreateViewModel(listLiveDataWrap,appNavigation,ClearViewModel.Base())

    }
}