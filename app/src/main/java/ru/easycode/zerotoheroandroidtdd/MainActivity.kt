package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var titleText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText = findViewById<TextView>(R.id.titleTextView)
        val buttonHide = findViewById<Button>(R.id.hideButton)

        buttonHide.setOnClickListener {
            titleText.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_VISIBILITY , titleText.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val visibilityText = savedInstanceState.getInt(KEY_VISIBILITY , titleText.visibility)
        titleText.visibility = visibilityText
    }
    companion object {
        private const val KEY_VISIBILITY = "key_visibility"
    }
}