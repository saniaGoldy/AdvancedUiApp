package com.example.advanceduiapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.advanceduiapp.data.PageData
import com.example.advanceduiapp.databinding.ActivityPagerBinding
import com.example.advanceduiapp.ui.pager.PagerFragment
import com.example.advanceduiapp.ui.pager.PagerViewModel

class PagerActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var binding: ActivityPagerBinding
    private val viewModel: PagerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        pager = findViewById(R.id.view_pager)
        val pagerAdapter = ImagePagerAdapter(supportFragmentManager, imageMap)
        pager.adapter = pagerAdapter

        viewModel.showMultipleViewRecyclerFragment.observe(this) {
            if (it) {
                showRecyclerFragment()
            }
        }
    }

    private fun showRecyclerFragment(){
        binding.viewPager.isVisible = false
        binding.fragmentContainerView.isVisible = true
    }

    override fun onBackPressed() {
        if (pager.currentItem == 0 || binding.fragmentContainerView.isVisible) super.onBackPressed() else pager.currentItem = pager.currentItem - 1
    }

    inner class ImagePagerAdapter(fragmentManager: FragmentManager, private val imageData: List<PageData>) :
        FragmentStatePagerAdapter(fragmentManager) {
        override fun getCount(): Int = imageData.size
        override fun getItem(position: Int): Fragment {
            return if (position == count - 1)
                PagerFragment.newInstance(
                    imageData[position].resourceId,
                    imageData[position].title,
                    true
                )
            else
                PagerFragment.newInstance(imageData[position].resourceId, imageData[position].title)
        }

    }

    companion object{
        val imageMap = listOf(
            PageData("CyberCiri", R.drawable.cybercyri),
            PageData("Geralt and Ciri", R.drawable.the_witcher_3_wild_hunt_geralt_of_rivia_sword_ciri_wallpaper_preview),
            PageData("Harley Qeen", R.drawable.harley_quinn___valentine_s_day_lingerie_by_hugotendaz_on_deviantart)
        )
    }
}
