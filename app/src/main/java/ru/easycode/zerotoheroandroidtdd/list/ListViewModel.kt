package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.create.CreateScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen



class ListViewModel(private val liveDataWrapper: ListLiveDataWrapper.Mutable,
                    private val navigation: Navigation.Update): ViewModel(),ListLiveDataWrapper.Read {

    fun create() {
        navigation.update(CreateScreen)
    }


    override fun read(): LiveData<List<CharSequence>> {
        return read()
    }
}