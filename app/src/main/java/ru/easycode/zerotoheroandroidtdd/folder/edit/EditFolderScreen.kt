package ru.easycode.zerotoheroandroidtdd.folder.edit

import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.folder.create.CreateFolderFragment
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderListFragment
import ru.easycode.zerotoheroandroidtdd.main.Screen

data class  EditFolderScreen(
    val folderId: Long,
): Screen.Replace(EditFolderFragment.newInstance(folderId))
