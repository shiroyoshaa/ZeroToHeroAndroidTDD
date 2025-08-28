package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import ru.easycode.zerotoheroandroidtdd.add.BottomSheetFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.TvAdapter
import ru.easycode.zerotoheroandroidtdd.core.TvHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity(), ProvideViewModel{
    var adapter = TvAdapter()
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomhseet = BottomSheetFragment()

        viewModel = viewModel(MainViewModel::class.java)

        viewModel.init()

        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            bottomhseet.show(supportFragmentManager,"BottomSheetFragment")
        }

        viewModel.liveData().observe(this) {
            Log.d("fatal",it.toString())
            adapter.setValue(it)
        }
    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return (application as ProvideViewModel).viewModel(viewModelClass)
    }
}