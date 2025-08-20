package ru.easycode.zerotoheroandroidtdd.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.App
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.list.ListScreen
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.MainViewModel

class MainActivity: AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = (application as App).mainViewModel
        viewModel.init(true)

        viewModel.liveData().observe(this) { screen ->
            when(screen) {
                is ListScreen -> {
                    val intent = Intent(this, ListActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}