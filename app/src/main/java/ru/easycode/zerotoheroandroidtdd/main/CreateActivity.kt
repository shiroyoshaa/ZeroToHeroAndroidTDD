package ru.easycode.zerotoheroandroidtdd.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.CreateFarmLayoutBinding

class CreateActivity: AppCompatActivity() {
    lateinit var binding: CreateFarmLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = CreateFarmLayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.inputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int, ) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int, ) {
                binding.createButton.isEnabled = binding.inputEditText.text.toString().length == 3
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }
}