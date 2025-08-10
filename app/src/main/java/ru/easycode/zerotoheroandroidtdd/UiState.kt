package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(progressBar: ProgressBar,textView: TextView,button: Button)

    object ShowProgress: UiState {
        override fun apply(progressBar: ProgressBar, textView: TextView, button: Button) {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
        }
    }

    data class ShowData(private val text: String): UiState {
        override fun apply(progressBar: ProgressBar, textView: TextView, button: Button) {
            textView.text = text
            progressBar.visibility = View.GONE
            textView.visibility = View.VISIBLE
            button.isEnabled = true
        }
    }
}