package com.example.advanceduiapp.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.advanceduiapp.databinding.FragmentPagerBinding

class PagerFragment(private val imageResource: Int, private val title: String, private val showButton: Boolean) : Fragment() {
    private val model: RecyclerViewModel by activityViewModels()

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
            textSlideshow.text = title
            pagerImageView.setImageResource(imageResource)
        }

        if (showButton) {
            binding.button.visibility = View.VISIBLE
            binding.button.setOnClickListener {
                model.showFrag4.value = true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(imageResource: Int, title: String, showButton: Boolean = false):PagerFragment =
            PagerFragment(imageResource, title, showButton)
    }
}