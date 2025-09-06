package ru.easycode.zerotoheroandroidtdd.note.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModels
import ru.easycode.zerotoheroandroidtdd.folder.core.FolderLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.folder.details.FolderDetailsScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.note.core.NoteListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.note.core.NoteLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.note.core.NotesRepository

class EditNoteViewModel(
    private val folderLiveDataWrapper: FolderLiveDataWrapper.Decrement,
    private val noteLiveDataWrapper: NoteLiveDataWrapper,
    private val noteListLiveDataWrapper:  NoteListLiveDataWrapper.Update,
    private val repository: NotesRepository.Edit,
    private val navigation: Navigation.Update,
    private val clear: ClearViewModels,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain: CoroutineDispatcher = Dispatchers.Main,

): ViewModel() {

    fun init(noteId: Long) {
        viewModelScope.launch(dispatcher) {

            val myNote = repository.note(noteId)
            noteLiveDataWrapper.update(myNote.title)
        }
    }
    fun deleteNote(noteId: Long) {
        viewModelScope.launch(dispatcher) {
            repository.deleteNote(noteId)
            folderLiveDataWrapper.decrement()
            comeback()
        }
    }

    fun renameNote(noteId:Long,newText: String) {
        viewModelScope.launch(dispatcher) {
            repository.renameNote(noteId,newText)
        }
        noteListLiveDataWrapper.update(noteId,newText)
        comeback()
    }

    fun comeback(){
        clear.clear(EditNoteViewModel::class.java)
        navigation.update(FolderDetailsScreen)
    }
}
