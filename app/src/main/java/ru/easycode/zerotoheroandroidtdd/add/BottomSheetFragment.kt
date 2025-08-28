package ru.easycode.zerotoheroandroidtdd.add

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.add.AddViewModel
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import kotlin.jvm.java
import kotlin.math.log

class BottomSheetFragment: BottomSheetDialogFragment() {
    lateinit var viewModel: AddViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = (activity as ProvideViewModel).viewModel(AddViewModel::class.java)
        val view = inflater.inflate(R.layout.add_layout,container,false)
        val button = view.findViewById<Button>(R.id.saveButton)
        val inputText = view.findViewById<TextInputEditText>(R.id.addInputEditText)
        button.setOnClickListener {
            viewModel.add(inputText.text.toString())
            inputText.setText("")
            dismiss()
        }
        return view
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        viewModel.comeback()
    }
}