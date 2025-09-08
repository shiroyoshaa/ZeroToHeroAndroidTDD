package ru.easycode.zerotoheroandroidtdd.folder.edit

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.EditFolderLayoutBinding

class EditFolderFragment: Fragment(R.layout.edit_folder_layout) {
    var _binding: EditFolderLayoutBinding? = null
    val binding
        get() = _binding!!
    companion object {
        private const val FOLDER_ID = "Folder_Id"
        fun newInstance(folderId: Long): EditFolderFragment  {
            val fragment = EditFolderFragment()
            fragment.arguments = Bundle().apply {
                putLong(FOLDER_ID,folderId)
            }
            return fragment
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EditFolderLayoutBinding.bind(view)
        val id = requireArguments().getLong(FOLDER_ID)
        var newText = ""

        parentFragmentManager.setFragmentResultListener("requestKey",viewLifecycleOwner) { requstKey, bundle ->
            newText = bundle.getString("bundleKey")!!
            binding.folderEditText.setText(newText)
        }

        val viewModel = (activity as ProvideViewModel).viewModel(EditFolderViewModel::class.java)

        binding.saveEditFolderButton.setOnClickListener {
            viewModel.renameFolder(id,binding.folderEditText.text.toString())
        }

        binding.deleteFolderButton.setOnClickListener {
            viewModel.deleteFolder(id)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            viewModel.comeback()
        }
    }
}
