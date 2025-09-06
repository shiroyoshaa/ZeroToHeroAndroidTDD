package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.easycode.zerotoheroandroidtdd.folder.core.FolderLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.folder.core.FoldersRepository
import ru.easycode.zerotoheroandroidtdd.folder.create.CreateFolderViewModel
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderListViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.note.core.Now

interface ProvideViewModel {
    fun <T : ViewModel> viewModel(clasz: Class<T>): T
    class Factory(private val provideViewModel: ProvideViewModel): ClearViewModels {

        private val map = mutableMapOf<Class<out ViewModel>, ViewModel>()

        fun <T : ViewModel> viewModel(modelClass: Class<T>): T {
            if(map.containsKey(modelClass)) {
                return map[modelClass] as T
            } else {
                val viewModel = provideViewModel.viewModel(modelClass)
                map[modelClass] = viewModel
                return viewModel
            }
        }

        override fun clear(vararg viewModelClasses: Class<out ViewModel>) {
            viewModelClasses.forEach {
                map.remove(it)
            }
        }
    }
    class Base(notesDao: NotesDao,foldersDao: FoldersDao,now: Now,private val clear: ClearViewModels): ProvideViewModel {
        private val navigation = Navigation.Base()
        private val folderRepository = FoldersRepository.Base(now,foldersDao,notesDao)
        private val foldersListLiveData = FolderListLiveDataWrapper.Base()
        private val foldersLiveData = FolderLiveDataWrapper.Base()
        override fun <T : ViewModel> viewModel(clasz: Class<T>): T {
            return when(clasz) {
                MainViewModel::class.java -> MainViewModel(navigation)
                FolderListViewModel:: class.java -> FolderListViewModel(folderRepository,foldersListLiveData,foldersLiveData,navigation)
                CreateFolderViewModel::class.java -> CreateFolderViewModel(folderRepository,
                    foldersListLiveData,navigation,clear)
                else -> throw IllegalStateException()
            } as T
        }
    }
}