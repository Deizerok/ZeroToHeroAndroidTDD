package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = (application as App).viewModel
        adapter = Adapter()

        binding.recyclerView.adapter = adapter
        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            mainViewModel.add(text)
            binding.inputEditText.setText("")
        }

        mainViewModel.liveData().observe(this) {
            adapter.update(it)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle, ) {
        super.onRestoreInstanceState(savedInstanceState)
        mainViewModel.restore(BundleWrapper.Base(savedInstanceState))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mainViewModel.save(BundleWrapper.Base(outState))
    }
}
