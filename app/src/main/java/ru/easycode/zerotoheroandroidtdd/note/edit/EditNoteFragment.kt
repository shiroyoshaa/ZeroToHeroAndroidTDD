package ru.easycode.zerotoheroandroidtdd.note.edit

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.EditNoteLayoutBinding

class EditNoteFragment: Fragment(R.layout.edit_note_layout){

    private var _binding: EditNoteLayoutBinding? = null
    private val binding
        get() = _binding!!


    companion object {

        private const val NOTE_ID = "note_id"
        fun newInstance(noteId: Long): EditNoteFragment {
            val instance = EditNoteFragment()
            instance.arguments = Bundle().apply {
                putLong(NOTE_ID,noteId)
            }
            return instance
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EditNoteLayoutBinding.bind(view)

        val id = requireArguments().getLong(NOTE_ID)
        val viewModel = (activity as ProvideViewModel).viewModel(EditNoteViewModel::class.java)

        viewModel.init(id)

        binding.saveEditNoteButton.setOnClickListener {
            viewModel.renameNote(id,binding.noteEditText.text.toString())
        }
        binding.deleteNoteButton.setOnClickListener {
            viewModel.deleteNote(id)
        }
        viewModel.liveData().observe(viewLifecycleOwner) {
            binding.noteEditText.setText(it)
        }
    }
}