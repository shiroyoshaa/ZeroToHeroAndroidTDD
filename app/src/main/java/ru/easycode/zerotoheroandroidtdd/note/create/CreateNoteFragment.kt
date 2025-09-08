package ru.easycode.zerotoheroandroidtdd.note.create

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.CreateNoteLayoutBinding

class CreateNoteFragment: Fragment(R.layout.create_note_layout) {
    private var _binding: CreateNoteLayoutBinding? = null
    private val binding
        get() = _binding!!
    companion object {
        private const val FOLDER_ID = "folder_id"
        fun newInstance(folderId: Long): CreateNoteFragment {
            var instance = CreateNoteFragment()
            instance.arguments = Bundle().apply {
                putLong(FOLDER_ID,folderId)
            }
            return instance
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CreateNoteLayoutBinding.bind(view)

        val id = requireArguments().getLong(FOLDER_ID)
        val viewModel = (activity as ProvideViewModel).viewModel(CreateNoteViewModel::class.java)
        binding.saveNoteButton.setOnClickListener {
            viewModel.createNote(id,binding.createNoteEditText.text.toString())
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            viewModel.comeback()
        }
    }
}