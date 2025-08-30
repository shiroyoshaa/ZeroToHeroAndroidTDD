package ru.easycode.zerotoheroandroidtdd.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.add.AddBottomSheet
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.TvAdapter
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.delete.DeleteBottomSheet
import ru.easycode.zerotoheroandroidtdd.delete.ItemUiDelete
import ru.easycode.zerotoheroandroidtdd.delete.MyClass

class MainActivity : AppCompatActivity(), ProvideViewModel {
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = viewModel(MainViewModel::class.java)




        val bottomSheet = AddBottomSheet()
        val newObject = object : ItemUiDelete {
            override fun delete(id: Long) {
                DeleteBottomSheet.newInstance(id)
                    .show(supportFragmentManager,"tag")
            }
        }

        val textBtn = MyClass.TEXT

        MyClass.setButtonText(binding.addButton,textBtn)

        val adapter = TvAdapter( newObject)

        binding.recyclerView.adapter = adapter
        binding.addButton.setOnClickListener {
            bottomSheet.show(supportFragmentManager,"bottomShit")
        }


        viewModel.liveData().observe(this) { items ->
            Log.d("fatal","live data observing $items")
            adapter.getText(items)

        }

    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
        return (application as ProvideViewModel).viewModel(viewModelClass)
    }

}