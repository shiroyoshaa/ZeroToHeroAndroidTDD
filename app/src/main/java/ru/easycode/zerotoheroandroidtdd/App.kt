package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import androidx.lifecycle.ViewModel

class App: Application(), ProvideViewModel {

    private lateinit var factory: ViewModelFactory
    val clear = object: ClearViewModel {
        override fun clearViewModel(clasz: Class<out ViewModel>) {
            return factory.clearViewModel(clasz)
        }
    }

    override fun onCreate() {
        super.onCreate()

        val now = Now.Base()
        val core = Core(context = this)
        factory = ViewModelFactory.Base(ProvideViewModel.Base(clear,core.dao(),now))
    }
    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return factory.viewModel(viewModelClass)
    }
}