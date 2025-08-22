package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel

class ListFragment: Fragment(R.layout.list_fram_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fatal","listFragment is start")
        val viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)
        val button = view.findViewById<FloatingActionButton>(R.id.addButton)
        button.setOnClickListener {
            viewModel.create()
        }
    }
}