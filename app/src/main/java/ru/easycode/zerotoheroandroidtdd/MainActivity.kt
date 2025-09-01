package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProvideViewModel {

    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val itemUiDelete = object : DeleteItemUi {
            override fun delete(itemUi: ItemUi) {
                DeleteAndDetailsBottomSheet.newInstance(itemUi).show(supportFragmentManager,"qwe")
            }
        }
        val viewModel = viewModel(MainViewModel::class.java)

        val adapter = TvAdapter(itemUiDelete)
        binding.recyclerView.adapter = adapter
        binding.addButton.setOnClickListener {
            AddBottomSheet().show(supportFragmentManager,"addBottomSheet")
        }

        viewModel.liveData().observe(this) {
            Log.d("fatal","observe is work")
            adapter.addOnList(it)
        }
        viewModel.init()
    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return (application as ProvideViewModel).viewModel(viewModelClass)
    }
}