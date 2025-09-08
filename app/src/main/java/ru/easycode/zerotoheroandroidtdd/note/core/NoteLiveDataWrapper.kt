package ru.easycode.zerotoheroandroidtdd.note.core

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.folder.details.NoteUi

interface NoteLiveDataWrapper  {

    fun update(noteText: String)
    fun liveData(): LiveData<String>


    interface All: NoteLiveDataWrapper

    class Base(private val liveData: MutableLiveData<String> = MutableLiveData()): All {
        override fun update(noteText: String) {
            liveData.value = noteText
        }
        override fun liveData(): LiveData<String> {
            Log.d("editNote",liveData.value.toString())
            return liveData
        }
    }
}


