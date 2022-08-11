package com.example.advanceduiapp

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.example.advanceduiapp.data.PageData
import com.example.advanceduiapp.databinding.ActivityPagerBinding
import com.example.advanceduiapp.ui.pager.PagerFragment
import com.example.advanceduiapp.ui.pager.PagerViewModel

class PagerActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager
    private lateinit var binding: ActivityPagerBinding
    private val model: PagerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        pager = findViewById(R.id.view_pager)
        val pagerAdapter = ImagePagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter

        val transitionStartedObserver = Observer<Boolean>{
            if (it){
                showRecyclerFragment()
            }
        }

        model.showMultipleViewRecyclerFragment.observe(this, transitionStartedObserver)
    }

    private fun showRecyclerFragment(){
        binding.viewPager.visibility = View.GONE
        binding.fragmentContainerView.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        if (pager.currentItem == 0) {
            super.onBackPressed()
        }else{
            pager.currentItem = pager.currentItem - 1
        }
    }

    inner class ImagePagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager) {
        override fun getCount(): Int = imageMap.size
        override fun getItem(position: Int): Fragment {
            return if (position == count - 1)
                PagerFragment.newInstance(
                    imageMap[position].resourceId,
                    imageMap[position].title,
                    true
                )
            else
                PagerFragment.newInstance(imageMap[position].resourceId, imageMap[position].title)
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
