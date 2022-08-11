package com.example.advanceduiapp.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.advanceduiapp.databinding.FragmentPagerBinding

class PagerFragment : Fragment() {
    private val model: PagerViewModel by activityViewModels()

    private var _binding: FragmentPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            textSlideshow.text = requireArguments().get(titleTag) as String
            pagerImageView.setImageResource(requireArguments().get(imageResourceTag) as Int)
        }

        if (requireArguments().get(showButtonTag) as Boolean) {
            binding.button.visibility = View.VISIBLE
            binding.button.setOnClickListener {
                model.showMultipleViewRecyclerFragment.value = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val imageResourceTag = "imageResource"
        private const val titleTag = "title"
        private const val showButtonTag = "showButton"

        fun newInstance(
            imageResource: Int,
            title: String,
            showButton: Boolean = false
        ): PagerFragment =
            PagerFragment().apply {
                arguments = bundleOf(
                    imageResourceTag to imageResource,
                    titleTag to title,
                    showButtonTag to showButton
                )
            }
    }
}