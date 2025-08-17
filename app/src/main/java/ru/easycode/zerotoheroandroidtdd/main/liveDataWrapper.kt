package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.LiveData

interface ListLiveDataWrapper {
    interface Add {
        fun add(source: CharSequence)
    }
    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }
    interface LiveData {
        fun liveData(): androidx.lifecycle.LiveData<List<CharSequence>>
    }
    interface Update{
        fun update(value: List<CharSequence>)
    }
    interface All: Add, Save, LiveData, Update

}