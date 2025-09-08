package ru.easycode.zerotoheroandroidtdd.folder.core

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderUi

interface FolderLiveDataWrapper {
    interface Update{
        fun update(folder: FolderUi)
    }
    interface FolderId {
        fun folderId(): Long
    }
    interface Rename {
        fun rename(newName: String)
    }
    interface Increment {
        fun increment()
    }
    interface Decrement {
        fun decrement()
    }
    interface Read {
        fun liveData(): LiveData<FolderUi>
    }

    interface Mutable: Update, FolderId, Read
    interface All: Mutable, Rename, Increment, Decrement

    class Base(private val liveData: MutableLiveData<FolderUi> = MutableLiveData()): All {

        override fun update(folder: FolderUi) {
            liveData.value = folder
        }

        override fun folderId(): Long {
            val newFolder = liveData.value
            return newFolder?.id ?: 0
        }

        override fun rename(newName: String) {
            val currentFolderUi = liveData.value
            currentFolderUi?.title = newName
            update(currentFolderUi!!)
        }

        override fun increment() {
            Log.d("noteTest","increment")
            val currentFolderUi = liveData.value
            currentFolderUi!!.notesCount++
            update(currentFolderUi)
        }

        override fun decrement() {
            val currentFolderUi = liveData.value
            currentFolderUi!!.notesCount--
            update(currentFolderUi)
        }

        override fun liveData(): LiveData<FolderUi> {
            return liveData
        }
    }
}