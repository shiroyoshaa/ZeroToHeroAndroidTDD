package ru.easycode.zerotoheroandroidtdd.note.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import ru.easycode.zerotoheroandroidtdd.folder.details.NoteUi

interface NoteListLiveDataWrapper {

    interface Updates {
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

    interface UpdateListAndRead: Updates, Update, Read
    interface All: UpdateListAndRead, Create

    class Base(private val liveData: MutableLiveData<ArrayList<NoteUi>> = MutableLiveData()): All {

        override fun update(notes: List<NoteUi>) {
            liveData.value = ArrayList(notes)
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