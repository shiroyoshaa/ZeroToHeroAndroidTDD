package ru.easycode.zerotoheroandroidtdd.core

import android.app.Application
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.dataBase.Core


class App: Application(), ProvideViewModel {

    lateinit var factory: ViewModelFactory
    private val clear = object: ClearViewModel {
        override fun clearViewModel(clasz: Class<out ViewModel>) {
            return factory.clearViewModel(clasz)
        }
    }
    override fun onCreate() {
        super.onCreate()
        val core = Core(applicationContext)
        val now = Now.Base()
        factory = ViewModelFactory.Base(ProvideViewModel.Base(core,now,clear))
    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return factory.viewModel(viewModelClass)
    }
}