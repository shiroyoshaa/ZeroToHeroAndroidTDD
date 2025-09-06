package ru.easycode.zerotoheroandroidtdd.note.core

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
    interface UpdateListAndRead: Updates
}