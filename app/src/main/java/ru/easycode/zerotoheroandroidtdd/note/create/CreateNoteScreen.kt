package ru.easycode.zerotoheroandroidtdd.note.create

import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.folder.create.CreateFolderFragment
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderListFragment
import ru.easycode.zerotoheroandroidtdd.main.Screen

data class CreateNoteScreen (
    val folderId: Long,

): Screen.Replace( CreateFolderFragment())
