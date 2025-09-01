package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.databinding.AddLayoutBinding


class AddBottomSheet: BottomSheetDialogFragment() {
    lateinit var viewModel: AddViewModel
    private var _binding: AddLayoutBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = (activity as ProvideViewModel).viewModel(AddViewModel::class.java)
        val binding = AddLayoutBinding.inflate(inflater,container,false)
        binding.saveButton.setOnClickListener {
            viewModel.add(binding.addInputEditText.text.toString())
            binding.addInputEditText.setText("")
            dismiss()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}