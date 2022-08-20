package com.example.advanceduiapp.ui.multiViewRecycler

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.advanceduiapp.adapters.MultipleViewRecyclerAdapter
import com.example.advanceduiapp.databinding.FragmentMultipleViewRecyclerBinding
import com.example.advanceduiapp.model.data.ItemData

class MultipleViewRecyclerFragment : Fragment() {

    private var _binding: FragmentMultipleViewRecyclerBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MultipleViewRecyclerViewModel by viewModels()
    private val adapter = MultipleViewRecyclerAdapter(listOf())

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMultipleViewRecyclerBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.multipleViewTypeList.adapter = adapter
        viewModel.itemsData.observe(this.viewLifecycleOwner){ itemsData: List<ItemData> ->
            adapter.update(itemsData)
        }

        return root
    }
}