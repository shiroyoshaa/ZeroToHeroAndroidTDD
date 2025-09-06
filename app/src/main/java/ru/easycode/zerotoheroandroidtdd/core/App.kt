package ru.easycode.zerotoheroandroidtdd.core

import android.app.Application
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.note.core.Now

class App: Application(), ProvideViewModel {
    lateinit var factory: ProvideViewModel.Factory
    private val now = Now.Base()
    private val clear = object : ClearViewModels {
        override fun clear(vararg viewModelClasses: Class<out ViewModel>) {
            factory.clear(*viewModelClasses)
        }
    }
    override fun onCreate() {
        super.onCreate()
        val core = Core(applicationContext)
        factory = ProvideViewModel.Factory(ProvideViewModel.Base(core.notesDao(),core.foldersDao(), now,clear))
    }

    override fun <T : ViewModel> viewModel(clasz: Class<T>): T {
        return factory.viewModel(clasz)
    }
}