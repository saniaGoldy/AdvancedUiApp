package com.example.advanceduiapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.advanceduiapp.model.data.PageData
import com.example.advanceduiapp.databinding.ActivityPagerBinding
import com.example.advanceduiapp.model.ConfigurationActivity
import com.example.advanceduiapp.ui.pager.PagerFragment
import com.example.advanceduiapp.ui.pager.PagerViewModel

class PagerActivity : ConfigurationActivity() {

    private lateinit var binding: ActivityPagerBinding
    private val viewModel: PagerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel.showMultipleViewRecyclerFragment.observe(this) { showMultipleViewRecycler: Boolean ->
            if (showMultipleViewRecycler) {
                swapPagerWithRecycler()
            }
        }

        viewModel.imageMap.observe(this){ imageMap: List<PageData> ->
            updateViewPager(imageMap)
        }
    }

    private fun updateViewPager(imageMap: List<PageData>){
        binding.viewPager.adapter = ImagePagerAdapter(supportFragmentManager, imageMap)
    }

    private fun swapPagerWithRecycler(){
        binding.viewPager.isVisible = !binding.viewPager.isVisible
        binding.fragmentContainerView.isVisible = !binding.fragmentContainerView.isVisible
    }

    override fun onBackPressed() = with(binding){
        if (viewPager.currentItem == 0 ) super.onBackPressed()
        else if(binding.fragmentContainerView.isVisible) swapPagerWithRecycler()
        else viewPager.currentItem = viewPager.currentItem - 1
    }

    inner class ImagePagerAdapter(fragmentManager: FragmentManager, private val imageData: List<PageData>) :
        FragmentStatePagerAdapter(fragmentManager) {
        override fun getCount(): Int = imageData.size
        override fun getItem(position: Int): Fragment = PagerFragment.newInstance(
            imageData[position].resourceId,
            imageData[position].title,
            position == count - 1
        )

    }
}
