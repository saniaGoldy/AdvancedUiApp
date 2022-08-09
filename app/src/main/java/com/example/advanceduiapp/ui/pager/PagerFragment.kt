package com.example.advanceduiapp.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.advanceduiapp.databinding.FragmentPagerBinding

class PagerFragment(private val imageResource: Int, private val title: String, private val showButton: Boolean) : Fragment() {

    private var _binding: FragmentPagerBinding? = null
    private val model: RecyclerViewModel by activityViewModels()

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

        if (showButton) {
            binding.button.visibility = View.VISIBLE
            binding.button.setOnClickListener {
                model.showFrag4.value = true
            }
        }

        return root
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