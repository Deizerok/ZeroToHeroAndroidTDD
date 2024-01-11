package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var btnEnabledRemove: Boolean = true
    private lateinit var btnRemove:Button
    private lateinit var txtView:TextView
    private lateinit var rootLinearLayout:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRemove = findViewById<Button>(R.id.removeButton)
        txtView = findViewById<TextView>(R.id.titleTextView)
        rootLinearLayout = findViewById<LinearLayout>(R.id.rootLayout)

        btnRemove.setOnClickListener {
            btnEnabledRemove = false
            btnRemove.isEnabled = btnEnabledRemove
            rootLinearLayout.removeView(txtView)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val btnEnabledRemove = savedInstanceState.getBoolean(BOOLEAN_BTN_KEY, btnEnabledRemove)
        if (btnEnabledRemove == false) {
            btnRemove.isEnabled = btnEnabledRemove
            rootLinearLayout.removeView(txtView)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(BOOLEAN_BTN_KEY, btnEnabledRemove)
    }
    companion object {
        private const val BOOLEAN_BTN_KEY = "boolean_key_btn"

    }
}