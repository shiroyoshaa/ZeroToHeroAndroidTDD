package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.easycode.zerotoheroandroidtdd.databinding.DeleteAndUpdateLayoutBinding

class DeleteAndDetailsBottomSheet: BottomSheetDialogFragment() {
    private var _binding: DeleteAndUpdateLayoutBinding? = null
    private val binding
        get() = _binding!!
    lateinit var viewModel: DetailsViewModel
    companion object {

        fun newInstance(itemUi: ItemUi): DeleteAndDetailsBottomSheet {
            val intance = DeleteAndDetailsBottomSheet()
            intance.arguments = Bundle().apply {
                putSerializable(KEY,itemUi)
            }
            return intance
        }
        private const val KEY = "keyItemUi"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = DeleteAndUpdateLayoutBinding.inflate(inflater,container,false)
        viewModel = (activity as ProvideViewModel).viewModel(DetailsViewModel::class.java)
        val arg = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getSerializable(KEY, ItemUi::class.java) as ItemUi
        } else {
            requireArguments().getSerializable(KEY) as ItemUi
        }
        viewModel.init(arg.id)
        binding.deleteButton.setOnClickListener {
            viewModel.delete(arg.id)
            dismiss()
        }
        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.itemTextView.text = it
            binding.itemInputEditText.setText(it)
        }
        binding.updateButton.setOnClickListener {
            viewModel.update(arg.id,binding.itemInputEditText.text.toString())
            dismiss()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
