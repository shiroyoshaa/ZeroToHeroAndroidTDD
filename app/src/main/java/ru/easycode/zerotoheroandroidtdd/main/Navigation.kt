package ru.easycode.zerotoheroandroidtdd.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.core.SingleLiveEvent

interface Navigation {

    interface Update {

        fun update(value: Screen)
    }

    interface LiveData {
        fun liveData(): androidx.lifecycle.LiveData<Screen>
    }
    interface Mutable: Update, LiveData, Navigation

    class Base(private val liveData: MutableLiveData<Screen> = SingleLiveEvent()): Mutable {

        override fun update(value: Screen) {
            liveData.value = value
        }

        override fun liveData(): androidx.lifecycle.LiveData<Screen> {
            return liveData
        }
    }
}