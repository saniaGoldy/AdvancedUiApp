package com.example.advanceduiapp.ui.pager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advanceduiapp.R
import com.example.advanceduiapp.model.data.PageData

class PagerViewModel: ViewModel() {
    private val _showMultipleViewRecyclerFragment = MutableLiveData(false)
    val showMultipleViewRecyclerFragment: LiveData<Boolean> get() = _showMultipleViewRecyclerFragment

    val imageMap = MutableLiveData(
        listOf(
            PageData("CyberCiri", R.drawable.cybercyri),
            PageData("Geralt and Ciri", R.drawable.the_witcher_3_wild_hunt_wallpaper),
            PageData("Harley Qeen", R.drawable.harley_quinn)
        )
    )

    fun switchRecyclerFragmentVisibility(){
        _showMultipleViewRecyclerFragment.value = !_showMultipleViewRecyclerFragment.value!!
    }
}