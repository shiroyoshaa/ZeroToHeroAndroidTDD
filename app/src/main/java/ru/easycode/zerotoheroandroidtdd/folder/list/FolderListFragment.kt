package ru.easycode.zerotoheroandroidtdd.folder.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModels
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.FoldersLayoutBinding
import ru.easycode.zerotoheroandroidtdd.folder.core.FolderAdapter

class FolderListFragment: Fragment(R.layout.folders_layout) {

    private var _binding: FoldersLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = (activity as ProvideViewModel).viewModel(FolderListViewModel::class.java)
        Log.d("fatal","onViewCreated")
        _binding = FoldersLayoutBinding.bind(view)
        val adapter = FolderAdapter {
            viewModel.folderDetails(it)
        }
        binding.foldersRecyclerView.adapter = adapter


        viewModel.init()

        binding.addButton.setOnClickListener {
            viewModel.addFolder()
        }

        viewModel.liveData().observe(viewLifecycleOwner) {
            Log.d("lifecycler","live data observe in FolderListfragment")
            adapter.setFolders(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d("lifecycler","onViewCreate")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lifecycler","onCreate")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("lifecycler","onViewStateRestored")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycler","OOOON DESTROOOOOOOOOOOOY")
    }
}

