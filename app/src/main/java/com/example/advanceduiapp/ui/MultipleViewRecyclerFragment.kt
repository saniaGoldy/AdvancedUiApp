package com.example.advanceduiapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.advanceduiapp.PagerActivity
import com.example.advanceduiapp.R
import com.example.advanceduiapp.data.MultipleViewRecyclerAdapter
import com.example.advanceduiapp.databinding.FragmentMultipleViewRecyclerBinding

class MultipleViewRecyclerFragment : Fragment() {
    private val textData = listOf<String>("some string", "Oi cunt", "wakee wakee", "mornin'")
    private val pageData = PagerActivity.imageMap
    private val buttonActions = listOf<() -> Unit>({
        Toast.makeText(
            this.requireContext(),
            getString(R.string.butcher_greeting),
            Toast.LENGTH_SHORT
        ).show()
    },
        {
            Toast.makeText(
                this.requireContext(),
                getString(R.string.homelander_phrase),
                Toast.LENGTH_SHORT
            ).show()
        }
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
            MultipleViewRecyclerAdapter(pageData, textData, buttonActions)
        return root
    }


}