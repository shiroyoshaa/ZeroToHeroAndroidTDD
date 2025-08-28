package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.easycode.zerotoheroandroidtdd.add.AddViewModel
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.Core
import ru.easycode.zerotoheroandroidtdd.core.ItemsDao
import ru.easycode.zerotoheroandroidtdd.core.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.core.Now
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.Repository
import ru.easycode.zerotoheroandroidtdd.core.ViewModelFactory
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel

class App: Application(), ProvideViewModel {
    lateinit var factory: ViewModelFactory
     var clear = object : ClearViewModel {
        override fun clearViewModel(clasz: Class<out ViewModel>) {
            factory.clearViewModel(clasz)
        }
    }
    override fun onCreate() {
        super.onCreate()
        val core = Core(this)
        factory = ViewModelFactory.Base(ProvideViewModel.Base(core,clear))
    }
    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return factory.viewModel(viewModelClass)
    }

}