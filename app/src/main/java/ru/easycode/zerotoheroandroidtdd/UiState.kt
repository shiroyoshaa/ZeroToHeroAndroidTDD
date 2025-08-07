package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState: Serializable {

    fun apply(progressBar: ProgressBar,textView: TextView,button: Button)

    object ShowProgress : UiState {

        override fun apply(progressBar: ProgressBar, textView: TextView, button: Button) {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
        }

    }
    object ShowData : UiState {

        override fun apply(progressBar: ProgressBar, textView: TextView, button: Button) {
            textView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            button.isEnabled = true
        }
    }
}