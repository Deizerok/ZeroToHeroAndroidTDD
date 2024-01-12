package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val count = Count.Base(2, 4)

    private var uiState: UiState = UiState.Base("0")

    private lateinit var countTextView: TextView
    private lateinit var buttonIncrement: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonIncrement = findViewById(R.id.incrementButton)
        countTextView = findViewById(R.id.countTextView)

        buttonIncrement.setOnClickListener {
            uiState = count.increment(countTextView.text.toString())
            uiState.apply(countTextView, buttonIncrement)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(UI_STATE_KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(UI_STATE_KEY) as UiState
        uiState.apply(countTextView, buttonIncrement)
    }

    companion object {
        private const val UI_STATE_KEY = "uiStateKey"
    }
}