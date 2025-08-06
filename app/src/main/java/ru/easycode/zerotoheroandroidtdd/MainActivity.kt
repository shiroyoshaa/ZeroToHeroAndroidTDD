package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import androidx.activity.viewModels
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
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