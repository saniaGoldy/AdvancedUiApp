package com.example.advanceduiapp.ui.pager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advanceduiapp.R
import com.example.advanceduiapp.data.PageData

class PagerViewModel: ViewModel() {
    val showMultipleViewRecyclerFragment = MutableLiveData<Boolean>(false)
    val imageMap = listOf(
        PageData("CyberCiri", R.drawable.cybercyri),
        PageData("Geralt and Ciri", R.drawable.the_witcher_3_wild_hunt_geralt_of_rivia_sword_ciri_wallpaper_preview),
        PageData("Harley Qeen", R.drawable.harley_quinn___valentine_s_day_lingerie_by_hugotendaz_on_deviantart)
    )
}