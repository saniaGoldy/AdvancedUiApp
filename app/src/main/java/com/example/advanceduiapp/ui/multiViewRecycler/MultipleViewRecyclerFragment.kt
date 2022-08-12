package com.example.advanceduiapp.ui.multiViewRecycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.advanceduiapp.R
import com.example.advanceduiapp.adapters.MultipleViewRecyclerAdapter
import com.example.advanceduiapp.data.ItemData
import com.example.advanceduiapp.data.ToastButtonData
import com.example.advanceduiapp.databinding.FragmentMultipleViewRecyclerBinding

class MultipleViewRecyclerFragment : Fragment() {

    private var _binding: FragmentMultipleViewRecyclerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MultipleViewRecyclerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMultipleViewRecyclerBinding.inflate(inflater, container, false)
        val root = binding.root
        viewModel.itemsData.observe(this.viewLifecycleOwner){ itemsData: List<ItemData> ->
            viewModel.toastButtonData.observe(this.viewLifecycleOwner){ toastStringResources: List<Int> ->
                val buttonItemsData = toastStringResources.map { ToastButtonData(this.requireContext(), getString(it)) }
                binding.multipleViewTypeList.adapter =
                    MultipleViewRecyclerAdapter(itemsData + buttonItemsData)
            }
        }
        return root
    }
}