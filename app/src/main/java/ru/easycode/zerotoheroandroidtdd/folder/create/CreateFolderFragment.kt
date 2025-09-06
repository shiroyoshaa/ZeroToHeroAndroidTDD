package ru.easycode.zerotoheroandroidtdd.folder.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.CreateFolderLayoutBinding

class CreateFolderFragment: Fragment(R.layout.create_folder_layout) {

    private var _binding: CreateFolderLayoutBinding? = null
    private val binding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = (activity as ProvideViewModel).viewModel(CreateFolderViewModel::class.java)

        _binding = CreateFolderLayoutBinding.bind(view)
        binding
        binding.saveFolderButton.setOnClickListener {
            viewModel.createFolder(binding.createFolderEditText.text.toString())
            binding.createFolderEditText.setText("")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d("fatal","onViewCreate in CreateFolder")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fatal","onCreate in CreateFolder")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("fatal","onViewStateRestored in CreateFolder")
    }
}