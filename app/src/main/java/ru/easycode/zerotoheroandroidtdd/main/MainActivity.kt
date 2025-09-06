package ru.easycode.zerotoheroandroidtdd.main

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.App
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProvideViewModel {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = viewModel(MainViewModel::class.java)
        viewModel.init(savedInstanceState == null)

        viewModel.livedata().observe(this) {
            Log.d("lifecycler","mainActivity observing")
            it.show(supportFragmentManager,binding.container.id)

     }

    }
    override fun <T : ViewModel> viewModel(clasz: Class<T>): T {
        return (application as ProvideViewModel).viewModel(clasz)
    }
}