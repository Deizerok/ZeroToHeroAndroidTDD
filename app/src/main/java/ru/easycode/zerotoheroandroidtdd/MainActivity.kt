package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val count:Count = Count.Base(2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIncrement = findViewById<Button>(R.id.incrementButton)
        val txtNumber = findViewById<TextView>(R.id.countTextView)
        btnIncrement.setOnClickListener {
            val result = count.increment(txtNumber.text.toString())
            txtNumber.text = result
        }
    }
}