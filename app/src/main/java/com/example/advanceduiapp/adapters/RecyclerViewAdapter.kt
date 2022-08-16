package com.example.advanceduiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.advanceduiapp.model.data.PageData
import com.example.advanceduiapp.databinding.FragmentPagerBinding

class RecyclerViewAdapter(private val data: List<PageData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        FragmentPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(
        binding: FragmentPagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val itemTitle = binding.textSlideshow
        private val itemImage = binding.pagerImageView

        fun bind(item: PageData) {
            itemTitle.text = item.title
            itemImage.setImageResource(item.resourceId)
        }
    }
}