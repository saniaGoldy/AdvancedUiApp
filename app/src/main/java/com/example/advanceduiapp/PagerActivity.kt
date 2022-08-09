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
import com.example.advanceduiapp.databinding.ActivityPagerBinding
import com.example.advanceduiapp.ui.pager.PagerFragment
import com.example.advanceduiapp.ui.pager.RecyclerViewModel

class PagerActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager
    private lateinit var binding: ActivityPagerBinding
    private val model: RecyclerViewModel by viewModels()

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

        model.showFrag4.observe(this, transitionStartedObserver)
    }

    fun showRecyclerFragment(){
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
                    imageMap[position].second,
                    imageMap[position].first,
                    true
                )
            else
                PagerFragment.newInstance(imageMap[position].second, imageMap[position].first)
        }

    }

    companion object{
        val imageMap = listOf(
            "CyberCiri" to R.drawable.cybercyri,
            "Geralt and Ciri" to R.drawable.the_witcher_3_wild_hunt_geralt_of_rivia_sword_ciri_wallpaper_preview,
            "Harley Qeen" to R.drawable.harley_quinn___valentine_s_day_lingerie_by_hugotendaz_on_deviantart
        )
    }
}
