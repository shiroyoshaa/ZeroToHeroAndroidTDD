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


class DeleteBottomSheet(private val id: Long,private val text: String): BottomSheetDialogFragment() {
    private var _binding: DeleteLayoutBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: DeleteViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = (activity as ProvideViewModel).viewModel(DeleteViewModel::class.java)
        _binding = DeleteLayoutBinding.inflate(inflater,container,false)
        binding.itemTitleTextView.text = text


        binding.deleteButton.setOnClickListener {
            viewModel.delete(id)
            dismiss()
        }
        return binding.root
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        _binding = null
        viewModel.comeback()
    }
}