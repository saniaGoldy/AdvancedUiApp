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
    private val viewModel: PagerViewModel by activityViewModels()

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
            textSlideshow.text = requireArguments().getString(TITLE_TAG)
            pagerImageView.setImageResource(requireArguments().getInt(IMAGE_RESOURCE_TAG))
        }

        if (requireArguments().getBoolean(SHOW_BUTTON_TAG)) {
            binding.button.visibility = View.VISIBLE
            binding.button.setOnClickListener {
                viewModel.switchRecyclerFragmentVisibility()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val IMAGE_RESOURCE_TAG = "imageResource"
        private const val TITLE_TAG = "title"
        private const val SHOW_BUTTON_TAG = "showButton"

        fun newInstance(
            imageResource: Int,
            title: String,
            showButton: Boolean = false
        ): PagerFragment =
            PagerFragment().apply {
                arguments = bundleOf(
                    IMAGE_RESOURCE_TAG to imageResource,
                    TITLE_TAG to title,
                    SHOW_BUTTON_TAG to showButton
                )
            }
    }
}