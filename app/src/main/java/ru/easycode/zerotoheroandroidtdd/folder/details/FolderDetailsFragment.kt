package ru.easycode.zerotoheroandroidtdd.folder.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FolderDetailsLayoutBinding


class FolderDetailsFragment: Fragment(R.layout.folder_details_layout) {

    private var _binding: FolderDetailsLayoutBinding? = null
    private val binding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FolderDetailsLayoutBinding.bind(view)

        val viewModel = (activity as ProvideViewModel).viewModel(FolderDetailsViewModel::class.java)
        viewModel.init()
        val adapter = NoteAdapter {
            viewModel.editNote(it)
        }

        binding.notesRecyclerView.adapter = adapter




        binding.editFolderButton.setOnClickListener {

            viewModel.editFolder()
        }
        binding.addNoteButton.setOnClickListener {
            viewModel.createNote()
        }


        viewModel.liveData().observe(viewLifecycleOwner) {
            binding.folderNameTextView.text = it.title
            parentFragmentManager.setFragmentResult("requestKey",
                bundleOf("bundleKey" to it.title)
                )
            Log.d("FolderTest","observe in detalis screen     ${it.title}")
            binding.notesCountTextView.text = it.notesCount.toString()
        }
        viewModel.noteLiveData().observe(viewLifecycleOwner) {
            Log.d("noteTest","observing details fragment")
            adapter.getNoteUi(it)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            viewModel.comeback()
        }
    }
}