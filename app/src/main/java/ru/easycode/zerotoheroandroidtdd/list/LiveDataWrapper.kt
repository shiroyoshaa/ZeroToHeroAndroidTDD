package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.core.SingleLiveEvent

interface LiveDataWrapper {

    interface Read<T : Any> {
        fun read(): LiveData<T>
    }
    interface Update<T: Any> {
        fun update(value: T)
    }

    interface Mutable<T : Any>: Read<T>,Update<T>

    abstract class Abstract<T : Any>(
        protected val liveData: MutableLiveData<T> = SingleLiveEvent()
    ): Mutable<T> {
        override fun update(value: T) {
            liveData.value = value
        }

        override fun read(): LiveData<T> = liveData

    }
}