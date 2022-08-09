package com.example.advanceduiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.advanceduiapp.ui.pager.PagerFragment

class PagerActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        supportActionBar?.hide()

        pager = findViewById(R.id.view_pager)
        val pagerAdapter = ImagePagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
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
        override fun getItem(position: Int): Fragment =
            PagerFragment.newInstance(imageMap[position].second, imageMap[position].first)

    }

    companion object{
        val imageMap = listOf(
            "CyberCiri" to R.drawable.cybercyri,
            "Geralt and Ciri" to R.drawable.the_witcher_3_wild_hunt_geralt_of_rivia_sword_ciri_wallpaper_preview,
            "Harley Qeen" to R.drawable.harley_quinn___valentine_s_day_lingerie_by_hugotendaz_on_deviantart
        )
    }
}
