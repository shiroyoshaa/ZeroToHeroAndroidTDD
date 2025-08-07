package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("save process", "onCreate: savedInstanceState is ${savedInstanceState != null}")
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            viewModel.load()
        }

        viewModel.liveData().observe(this) {
            Log.d("obersver","obersved is run")
            it.apply(binding.progressBar,binding.titleTextView,binding.actionButton)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("save process","onSaveIntance")
        viewModel.save(BundleWrapper.Save.Base(outState))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("save process","onDestroy")
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.actionButton.isEnabled = false
        Log.e("save process","onRestoreIntance")
        viewModel.restore(BundleWrapper.Restore.Base(savedInstanceState))
    }
}