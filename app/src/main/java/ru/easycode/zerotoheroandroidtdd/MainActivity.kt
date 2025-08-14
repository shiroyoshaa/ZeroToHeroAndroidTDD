package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val adapter  = TvAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as App).viewModel
        binding.recyclerView.adapter = adapter
        binding.actionButton.setOnClickListener {
            val txt = binding.inputEditText.text.toString()
            Log.e("testingAdapter","button is clicked with text - ${txt.toString()}")
            viewModel.add(txt)
            binding.inputEditText.setText("")
        }
        viewModel.liveData().observe(this) {
            adapter.set(it)
        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(bundle = BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.restore(BundleWrapper.Base(savedInstanceState))
    }
}