package com.example.advanceduiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.*
import com.example.advanceduiapp.data.*
import com.example.advanceduiapp.databinding.ButtonItemBinding
import com.example.advanceduiapp.databinding.FragmentPagerBinding
import com.example.advanceduiapp.databinding.TvItemBinding

class MultipleViewRecyclerAdapter(
    private val itemData: List<ItemData>
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            ViewType.Page.typeId -> PageViewHolder(FragmentPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            ViewType.Text.typeId -> TVViewHolder(TvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> ButtonViewHolder(ButtonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemData[position].type.typeId
    }

    override fun getItemCount(): Int {
        return itemData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as PageViewHolder).bind(itemData[position] as PageData)
            1 -> (holder as TVViewHolder).bind(itemData[position] as TextData)
            else -> (holder as ButtonViewHolder).bind(itemData[position] as ToastButtonData)
        }
    }


    inner class TVViewHolder(binding: TvItemBinding): ViewHolder(binding.root){

        private val itemTV = binding.itemTV

        fun bind(item: TextData){
            itemTV.text = item.text
        }
    }


    inner class PageViewHolder(
        binding: FragmentPagerBinding
    ) : ViewHolder(binding.root) {

        private val itemTitle = binding.textSlideshow

        private val itemImage = binding.pagerImageView
        fun bind(item: PageData) {
            itemTitle.text = item.title
            itemImage.setImageResource(item.resourceId)
        }
    }


    inner class ButtonViewHolder(binding: ButtonItemBinding): ViewHolder(binding.root) {

        private val itemButton = binding.itemButton

        fun bind(item: ToastButtonData) {
            itemButton.setOnClickListener { Toast.makeText(item.context, item.message, Toast.LENGTH_SHORT).show() }
        }
    }
}