package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.core.TvAdapter
import ru.easycode.zerotoheroandroidtdd.main.ViewModels.CreateViewModel

class ListFragment: Fragment(R.layout.list_fram_layout) {

    lateinit var viewModel: ListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TvAdapter()

        viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)
        val button = view.findViewById<FloatingActionButton>(R.id.addButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter

        button.setOnClickListener {
            viewModel.create()
        }
        viewModel.liveData().observe(viewLifecycleOwner) {

            adapter.addText(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("stateLogger","onSaveInstance")
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("stateLogger","onRestoreIntance")
        if(savedInstanceState != null) {
            viewModel.restore(BundleWrapper.Base(savedInstanceState))
        }
    }
}