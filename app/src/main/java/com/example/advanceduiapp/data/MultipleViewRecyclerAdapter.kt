package com.example.advanceduiapp.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.advanceduiapp.databinding.ButtonItemBinding
import com.example.advanceduiapp.databinding.FragmentPagerBinding
import com.example.advanceduiapp.databinding.TvItemBinding

class MultipleViewRecyclerAdapter(
    private val pageData: List<Pair<String, Int>>,
    private val textData: List<String>,
    private val buttonActionsData: List<() -> Unit>
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            0 -> PageViewHolder(FragmentPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            1 -> TVViewHolder(TvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> ButtonViewHolder(ButtonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            in 0..pageData.lastIndex -> 0
            in pageData.size..(pageData.size+textData.lastIndex) -> 1
            else -> 2
        }
    }

    override fun getItemCount(): Int {
        return pageData.size + textData.size + buttonActionsData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> (holder as PageViewHolder).bind(pageData[position])
            1 -> (holder as TVViewHolder).bind(textData[position - pageData.size])
            else -> (holder as ButtonViewHolder).bind { buttonActionsData[position - pageData.size - textData.size] }
        }
    }

    inner class PageViewHolder(
        binding: FragmentPagerBinding
    ) : ViewHolder(binding.root) {
        private val itemTitle = binding.textSlideshow

        private val itemImage = binding.pagerImageView
        fun bind(item: Pair<String, Int>) {
            itemTitle.text = item.first
            itemImage.setImageResource(item.second)
        }
    }

    inner class TVViewHolder(binding: TvItemBinding): ViewHolder(binding.root){
        private val itemTV = binding.itemTV
        fun bind(item: String){
            itemTV.text = item
        }
    }

    inner class ButtonViewHolder(binding: ButtonItemBinding): ViewHolder(binding.root){
        private val itemButton = binding.itemButton
        fun bind(item: ()->Unit){
            itemButton.setOnClickListener { item.invoke() }
        }
    }
}