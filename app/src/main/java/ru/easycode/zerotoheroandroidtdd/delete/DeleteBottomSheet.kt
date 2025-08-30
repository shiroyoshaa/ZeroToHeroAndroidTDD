package ru.easycode.zerotoheroandroidtdd.delete
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.DeleteLayoutBinding
import java.text.AttributedString


class DeleteBottomSheet(): BottomSheetDialogFragment() {
    private var _binding: DeleteLayoutBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: DeleteViewModel
    companion object {
        fun newInstance(itemId: Long): DeleteBottomSheet {
            val instance = DeleteBottomSheet()
            instance.arguments = Bundle().apply {
                putLong(KEY,itemId)
            }
            return instance
        }
        private const val KEY = "itemIdToDelete"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = (activity as ProvideViewModel).viewModel(DeleteViewModel::class.java)
        _binding = DeleteLayoutBinding.inflate(inflater,container,false)

        val itemId = requireArguments().getLong(KEY)

        viewModel.init(itemId)

        binding.deleteButton.setOnClickListener {
            viewModel.delete(itemId)
            dismiss()
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.itemTitleTextView.text = it
        }

        return binding.root
    }


    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        _binding = null
        viewModel.comeback()
    }
}