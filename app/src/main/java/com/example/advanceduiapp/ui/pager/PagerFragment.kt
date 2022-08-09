package com.example.advanceduiapp.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.advanceduiapp.databinding.FragmentPagerBinding

class PagerFragment(private val imageResource: Int, private val title: String) : Fragment() {

    private var _binding: FragmentPagerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPagerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.textSlideshow.text = title

        binding.pagerImageView.setImageResource(imageResource)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(imageResource: Int, title: String):PagerFragment =
            PagerFragment(imageResource, title)
    }
}