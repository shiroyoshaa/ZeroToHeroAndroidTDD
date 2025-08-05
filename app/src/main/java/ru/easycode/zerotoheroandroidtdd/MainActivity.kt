package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var viewModel =  MainViewModel(LiveDataWrapper.Base(),Repository.Base())
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.actionButton.setOnClickListener {
            viewModel.load()
        }
        viewModel.liveData().observe(this) {Uistate ->
            Uistate.apply(binding.progressBar,binding.titleTextView,binding.actionButton)
        }
    }
}