package ru.easycode.zerotoheroandroidtdd.folder.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map


interface NoteListLiveDataWrapper {

    interface UpdateSecond {
        fun update(notes: List<NoteUi>)
    }

    interface Create {
        fun create(noteUi: NoteUi)
    }

    interface Update {
        fun update(noteId: Long, newText: String)
    }

    interface Read {
        fun liveData(): LiveData<List<NoteUi>>
    }

    interface UpdateListAndRead: UpdateSecond, Read
    interface All: UpdateListAndRead, Create, Update

    class Base(private val liveData: MutableLiveData<ArrayList<NoteUi>> = MutableLiveData()): All {

        override fun update(notes: List<NoteUi>) {
            val newArray = ArrayList(notes)
            liveData.value = newArray
        }

        override fun update(noteId: Long, newText: String) {
            val newNoteUi = NoteUi(noteId,newText,0)
        }

        override fun liveData(): LiveData<List<NoteUi>> {
            return liveData.map { it.toList() }
        }

        override fun create(noteUi: NoteUi) {
          val currentList = liveData.value
            val newList = ArrayList(currentList)
            newList.add(noteUi)
            update(newList)
        }
    }
}