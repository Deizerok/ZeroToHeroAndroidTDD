package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textViewTitle: TextView
    private lateinit var linearLayoutRoot: LinearLayout
    private var isTextViewVisible: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutRoot = findViewById(R.id.rootLayout)
        val btnRemove = findViewById<Button>(R.id.removeButton)
        textViewTitle = findViewById<TextView>(R.id.titleTextView)

        btnRemove.setOnClickListener {
            toggleTextViewVisibility()
        }

        if (savedInstanceState != null) {
            isTextViewVisible = savedInstanceState.getBoolean(KEY_VISIBILITY, true)
            updateTextViewVisibility()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_VISIBILITY, isTextViewVisible)
    }

    private fun toggleTextViewVisibility() {
        isTextViewVisible = !isTextViewVisible
        updateTextViewVisibility()
    }

    private fun updateTextViewVisibility() {
        if (isTextViewVisible) {
            linearLayoutRoot.addView(textViewTitle)
        } else {
            linearLayoutRoot.removeView(textViewTitle)
        }
    }

    companion object {
        private const val KEY_VISIBILITY = "key_visibility"
    }
}

