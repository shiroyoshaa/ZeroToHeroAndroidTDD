package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.changeButton)
        a.text = getSharedPreferences("text", MODE_PRIVATE).getString("ww",a.text.toString())
        button.setOnClickListener {
            a.text = "I am an Android Developer!"
            getSharedPreferences("text", MODE_PRIVATE)
                .edit()
                .putString("ww","I am an Android Developer!")
                .apply()
        }
    }
}