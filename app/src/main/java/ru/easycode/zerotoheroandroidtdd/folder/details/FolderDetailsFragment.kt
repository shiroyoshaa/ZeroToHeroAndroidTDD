package ru.easycode.zerotoheroandroidtdd.folder.details

import android.os.Bundle
import android.view.View
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
    }
}