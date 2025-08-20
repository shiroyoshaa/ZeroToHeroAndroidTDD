package ru.easycode.zerotoheroandroidtdd.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.App
import ru.easycode.zerotoheroandroidtdd.list.TvAdapter
import ru.easycode.zerotoheroandroidtdd.create.CreateScreen
import ru.easycode.zerotoheroandroidtdd.databinding.ListFramLayoutBinding
import ru.easycode.zerotoheroandroidtdd.list.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel

class ListActivity: AppCompatActivity() {
    lateinit var listViewModel: ListViewModel
    lateinit var binding: ListFramLayoutBinding
     var adapter = TvAdapter()
    lateinit var appNavigation: Navigation.Mutable
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ListFramLayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listViewModel = (application as App).listViewModel
        binding.recyclerView.adapter = adapter
        appNavigation = (application as App).appNavigation
//        val intent = Intent(this, CreateActivity::class.java)
        binding.addButton.setOnClickListener {
            listViewModel.create()
//            startActivity(intent)
        }

       appNavigation.liveData().observe(this) { screen ->
            when(screen) {
                is CreateScreen -> {
                    val intent = Intent(this, CreateActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        listViewModel.liveData().observe(this) {
            adapter.addText(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        listViewModel.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        listViewModel.restore(BundleWrapper.Base(savedInstanceState))
    }
}