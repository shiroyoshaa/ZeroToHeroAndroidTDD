package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.ListViewModel

class App: Application() {
    private val createViewModel: CreateViewModel
    private val listViewModel: ListViewModel

    override fun onCreate() {
        super.onCreate()
        createViewModel = CreateViewModel(ListLiveDataWrapper.Add,Navigation.Update, clearViewModel = ClearViewModel)

    }
}