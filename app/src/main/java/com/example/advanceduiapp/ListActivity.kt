package com.example.advanceduiapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.advanceduiapp.adapters.RecyclerViewAdapter
import com.example.advanceduiapp.databinding.ActivityListBinding
import com.example.advanceduiapp.ui.pager.PagerViewModel

class ListActivity : AppCompatActivity() {

    private val viewModel: PagerViewModel by viewModels()
    private lateinit var binding: ActivityListBinding
    private val adapter = RecyclerViewAdapter(listOf())

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.imagesList.adapter = adapter
        viewModel.imageMap.observe(this) { imageMap ->
            adapter.update(imageMap)
        }
    }
}
