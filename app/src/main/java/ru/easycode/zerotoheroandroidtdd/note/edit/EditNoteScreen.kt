package ru.easycode.zerotoheroandroidtdd.note.edit

import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.folder.create.CreateFolderFragment
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderListFragment
import ru.easycode.zerotoheroandroidtdd.main.Screen

data class EditNoteScreen(
    val noteId: Long,
): Screen.Replace(CreateFolderFragment())
