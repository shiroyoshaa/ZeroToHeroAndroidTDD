package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.isInvisible
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var b: TextView
    private lateinit var cs: LinearLayout
    private val TEXT_KEY = "example of text"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityLifecycle","oncreate")
        setContentView(R.layout.activity_main)
            cs = findViewById(R.id.rootLayout)
        var a = findViewById<Button>(R.id.removeButton)
         b =  findViewById<TextView>(R.id.titleTextView)
        a.setOnClickListener {
            cs.removeView(b)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d("ActivityLifecycle","on create")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle","on pause!")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle","on stop!")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("ActivityLifecycle","onSaveInState")
    }
    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle","on start!")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        cs.removeView(b)
            Log.d("ActivityLifecycle","on restoreinstate")
        }
    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle","on resume!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "onDestroy вызван")
    }
}