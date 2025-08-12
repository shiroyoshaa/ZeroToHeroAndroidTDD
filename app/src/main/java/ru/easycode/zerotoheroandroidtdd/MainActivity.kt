package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val list: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val txt = binding.inputEditText.text.toString()
            val textView = TextView(this).apply {
                text = txt
            }
            list.add(txt)
            binding.contentLayout.addView(textView)
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(KEY, ArrayList(list))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedList = savedInstanceState.getStringArrayList(KEY)
        savedList?.forEach {
            val textview = TextView(this).apply {
                text = it
            }
            binding.contentLayout.addView(textview)
        }
    }
    companion object {
        private const val KEY = "KEY"
    }
}
