package com.example.advanceduiapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.advanceduiapp.PagerActivity
import com.example.advanceduiapp.R
import com.example.advanceduiapp.adapters.MultipleViewRecyclerAdapter
import com.example.advanceduiapp.data.ItemData
import com.example.advanceduiapp.data.PageData
import com.example.advanceduiapp.data.TextData
import com.example.advanceduiapp.data.ToastButtonData
import com.example.advanceduiapp.databinding.FragmentMultipleViewRecyclerBinding

class MultipleViewRecyclerFragment : Fragment() {
    private val itemsData
        get() = listOf(
            PageData(
                "harley",
                R.drawable.harley_quinn___valentine_s_day_lingerie_by_hugotendaz_on_deviantart
            ),
            TextData("Oi cunt"),
            ToastButtonData(this.requireContext(), getString(R.string.butcher_greeting)),
            TextData("wakee wakee"),
            ToastButtonData(this.requireContext(), getString(R.string.homelander_phrase))
        )

    private var _binding: FragmentMultipleViewRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMultipleViewRecyclerBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.multipleViewTypeList.adapter =
            MultipleViewRecyclerAdapter(itemsData)
        return root
    }


}