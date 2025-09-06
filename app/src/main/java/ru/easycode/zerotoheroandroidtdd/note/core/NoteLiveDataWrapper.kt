package ru.easycode.zerotoheroandroidtdd.note.core

import androidx.lifecycle.MutableLiveData

interface NoteLiveDataWrapper: LiveData.Update<String> {

    class Base: NoteLiveDataWrapper, LiveData.Abstract<String>()

}

interface LiveData{
    interface Update<T: Any> {
        fun update(value: T)
    }
    abstract class Abstract <T:Any>(protected val livedata: MutableLiveData<T> = MutableLiveData()):
        Update<T> {
        override fun update(value: T) {
            livedata.value = value
        }
    }
}

