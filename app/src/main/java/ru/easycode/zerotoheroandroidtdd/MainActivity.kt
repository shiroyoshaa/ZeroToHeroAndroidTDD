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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.w3c.dom.Text

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private var repository: Repository = DefaultRepository()
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
        viewModel.load()
        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            lifecycleScope.launch {
                delay(3500)
                progressBar.visibility = View.GONE
                textView.visibility = View.VISIBLE
                button.isEnabled = true
            }
        }
    }
}
