package com.example.advanceduiapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.advanceduiapp.adapters.RecyclerViewAdapter
import com.example.advanceduiapp.databinding.ActivityListBinding
import com.example.advanceduiapp.model.ConfigurationActivity
import com.example.advanceduiapp.ui.pager.PagerViewModel

class ListActivity : ConfigurationActivity() {

    private val viewModel: PagerViewModel by viewModels()
    private lateinit var binding:ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        viewModel.imageMap.observe(this){ imageMap -> binding.imagesList.adapter = RecyclerViewAdapter(imageMap) }
    }

}
