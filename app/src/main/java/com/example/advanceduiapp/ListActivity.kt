package com.example.advanceduiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.advanceduiapp.adapters.RecyclerViewAdapter
import com.example.advanceduiapp.databinding.ActivityListBinding
import com.example.advanceduiapp.ui.pager.PagerViewModel

class ListActivity : AppCompatActivity() {

    private val viewModel: PagerViewModel by viewModels()
    private lateinit var binding:ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.imagesList.adapter = RecyclerViewAdapter(viewModel.imageMap)
    }
}
