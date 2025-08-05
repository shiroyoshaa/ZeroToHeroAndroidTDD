package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {


    private val viewModel = MainViewModel(LiveDataWrapper.Base(),Repository.Base())
    lateinit var liveDataWrapper: LiveDataWrapper
    lateinit var button: Button
    lateinit var progressBar: ProgressBar
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        button = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)
        progressBar = findViewById(R.id.progressBar)

        button.setOnClickListener {
            viewModel.load()
        }
        viewModel.livaData().observe(this) { UiState ->
                UiState.apply(textView,button,progressBar)
        }
    }
}

