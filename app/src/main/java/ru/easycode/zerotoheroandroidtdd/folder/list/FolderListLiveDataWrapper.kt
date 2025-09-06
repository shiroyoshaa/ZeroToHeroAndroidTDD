package ru.easycode.zerotoheroandroidtdd.folder.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map

interface FolderListLiveDataWrapper {
    interface Create {
        fun create(folderUi: FolderUi)
    }
    interface Read {
        fun liveData(): LiveData<List<FolderUi>>
    }
    interface Update {
        fun update(list: List<FolderUi>)
    }
    interface UpdateListAndRead: Update, Read
    interface All: UpdateListAndRead, Create
    class Base(private val liveData: MutableLiveData<ArrayList<FolderUi>> = MutableLiveData()): All {
        override fun update(list: List<FolderUi>) {
            val newList = ArrayList(list)
            liveData.postValue(newList)
        }

        override fun create(folderUi: FolderUi) {
            val currentList = liveData.value?: ArrayList()
            currentList.add(folderUi)
            update(currentList)
        }

        override fun liveData(): LiveData<List<FolderUi>> {
            return liveData.map { it.toList() }
        }
    }
}