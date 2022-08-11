package com.example.advanceduiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.advanceduiapp.adapters.RecyclerViewAdapter
import com.example.advanceduiapp.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private val data = PagerActivity.imageMap
    private lateinit var binding:ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.imagesList.adapter = RecyclerViewAdapter(data)
    }
}
