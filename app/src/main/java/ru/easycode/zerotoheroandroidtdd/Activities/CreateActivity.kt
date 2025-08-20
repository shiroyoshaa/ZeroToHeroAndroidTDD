package ru.easycode.zerotoheroandroidtdd.Activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.App
import ru.easycode.zerotoheroandroidtdd.databinding.CreateFarmLayoutBinding
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.CreateViewModel

class CreateActivity: AppCompatActivity() {
    lateinit var createViewModel: CreateViewModel
    lateinit var binding: CreateFarmLayoutBinding
    lateinit var appNavigation: Navigation.Mutable
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = CreateFarmLayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        createViewModel = (application as App).createViewModel
        appNavigation = (application as App).appNavigation
        binding.createButton.setOnClickListener {

            val txt = binding.inputEditText.text.toString()
            createViewModel.add(txt)
        }
        binding.inputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int, ) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int, ) {
                binding.createButton.isEnabled = binding.inputEditText.text.toString().length >= 3
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        appNavigation.liveData().observe(this) {screen ->
            when(screen) {
                is Screen.Pop ->{
                    finish()
                }
            }
        }
    }
}