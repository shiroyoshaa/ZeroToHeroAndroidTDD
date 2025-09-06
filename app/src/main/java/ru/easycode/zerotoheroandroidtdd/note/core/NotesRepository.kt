package ru.easycode.zerotoheroandroidtdd.note.core

import ru.easycode.zerotoheroandroidtdd.core.NoteCache
import ru.easycode.zerotoheroandroidtdd.core.NotesDao

interface NotesRepository {
    interface NoteList {
        suspend fun noteList(folderId: Long): List<MyNote>
    }
    interface Create {
        suspend fun createNote(folderId: Long, text: String): Long
    }
    interface DeleteNote {
        suspend fun deleteNote(noteId: Long)
    }
    interface RenameNote {
        suspend fun renameNote(noteId: Long, newName: String)
    }
    interface Note {
        suspend fun note(noteId: Long): MyNote
    }
    interface ReadList: NoteList
    interface Edit: DeleteNote, RenameNote, Note
    class Base(
        private val now: Now,
        private val dao: NotesDao,
    ): Create, ReadList, Edit{

        override suspend fun createNote(folderId: Long, text: String): Long {
            val id = now.timeInMillis()
            val newItem = NoteCache(id,text,folderId)
            dao.insert(newItem)
            return id
        }

        override suspend fun noteList(folderId: Long): List<MyNote> {
            val newNoteList = dao.notes(folderId)
            val convertedList = newNoteList.map {
                MyNote(
                    id = it.id,
                    title = it.text,
                    folderId = it.folderId
                )
            }
            return convertedList
        }

        override suspend fun deleteNote(noteId: Long) {
            dao.delete(noteId)
        }

        override suspend fun renameNote(noteId: Long, newName: String) {
            val oldCache = dao.note(noteId)
            val newCache = NoteCache(id = oldCache.id, text = newName, folderId = oldCache.folderId)
            dao.insert(newCache)
        }

        override suspend fun note(noteId: Long): MyNote {
            val noteCache  = dao.note(noteId)
            val myNote = MyNote(id = noteCache.id,
                title = noteCache.text,
                folderId = noteCache.folderId,
                )
            return myNote
        }
    }
}