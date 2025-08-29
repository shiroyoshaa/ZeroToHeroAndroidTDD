package ru.easycode.zerotoheroandroidtdd.add

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.AddLayoutBinding

class AddBottomSheet: BottomSheetDialogFragment() {
    private var _binding : AddLayoutBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: AddViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = AddLayoutBinding.inflate(inflater,container,false)
        viewModel = (activity as ProvideViewModel).viewModel(AddViewModel::class.java)

        binding.saveButton.setOnClickListener {
            viewModel.add(binding.addInputEditText.text.toString())
            binding.addInputEditText.setText("")
            dismiss()
        }
        return binding.root
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        viewModel.comeback()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}