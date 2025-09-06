package ru.easycode.zerotoheroandroidtdd.folder.core

import ru.easycode.zerotoheroandroidtdd.core.FolderCache
import ru.easycode.zerotoheroandroidtdd.core.FoldersDao
import ru.easycode.zerotoheroandroidtdd.core.NotesDao
import ru.easycode.zerotoheroandroidtdd.note.core.Now

interface FoldersRepository {

    interface Create {
        suspend fun createFolder(name: String): Long
    }
    interface Delete {
        suspend fun delete(folderId: Long)
    }
    interface Rename {
        suspend fun rename(folderId: Long, newName: String)
    }
    interface Folders {
        suspend fun folders(): List<Folder>
    }
    interface Edit: Delete, Rename
    interface ReadList: Folders
    class Base(private val now: Now,
        private val foldersDao: FoldersDao,
        private val notesDao: NotesDao): Edit, ReadList, Create {
        override suspend fun delete(folderId: Long) {
            foldersDao.delete(folderId)
            notesDao.deleteByFolderId(folderId)
        }

        override suspend fun rename(folderId: Long, newName: String) {
            val newFolderCache = FolderCache(folderId,newName)
            foldersDao.insert(newFolderCache)
        }

        override suspend fun folders(): List<Folder> {
            val folders = foldersDao.folders()
            val convertedFolders = folders.map {
                Folder(
                    id = it.id,
                    title = it.text,
                    notesCount = notesDao.notes(it.id).size
                )
            }
            return convertedFolders
        }

        override suspend fun createFolder(name: String): Long {
            val newId = now.timeInMillis()
            val newFolder = FolderCache(newId,name)
            foldersDao.insert(newFolder)
            return newId
        }

    }
}