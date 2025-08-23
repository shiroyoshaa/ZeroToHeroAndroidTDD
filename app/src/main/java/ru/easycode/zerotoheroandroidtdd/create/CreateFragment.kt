package ru.easycode.zerotoheroandroidtdd.create

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.CreateViewModel

class CreateFragment: Fragment(R.layout.create_farm_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.inputEditText)
        val btn = view.findViewById<Button>(R.id.createButton)

        val viewModel = (activity as ProvideViewModel).viewModel(CreateViewModel::class.java)

        requireActivity().onBackPressedDispatcher.addCallback(object :OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = viewModel.comeback()
        })

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btn.isEnabled = editText.text.length >= 3
            }
            override fun afterTextChanged(s: Editable?) {}
        })
        btn.setOnClickListener {
            viewModel.add(editText.text.toString())
        }
    }
}