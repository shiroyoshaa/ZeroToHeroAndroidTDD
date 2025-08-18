package ru.easycode.zerotoheroandroidtdd.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ListFramLayoutBinding
import ru.easycode.zerotoheroandroidtdd.databinding.TvForadapterBinding

class ListActivity: AppCompatActivity() {
    lateinit var binding: ListFramLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ListFramLayoutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent(this, CreateActivity::class.java)
        binding.addButton.setOnClickListener {
            startActivity(intent)
        }
    }
}