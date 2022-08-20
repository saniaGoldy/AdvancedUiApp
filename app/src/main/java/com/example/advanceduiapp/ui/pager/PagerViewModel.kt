package com.example.advanceduiapp.ui.pager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advanceduiapp.R
import com.example.advanceduiapp.model.data.PageData

class PagerViewModel(application: Application): AndroidViewModel(application) {
    private val _showMultipleViewRecyclerFragment = MutableLiveData<Boolean>(false)
    val showMultipleViewRecyclerFragment: LiveData<Boolean> get() = _showMultipleViewRecyclerFragment

    val imageMap = MutableLiveData(
        listOf(
            PageData(application.getString(R.string.ciryImageTitle), R.drawable.cybercyri),
            PageData(application.getString(R.string.Geralt_and_Ciri_Title), R.drawable.the_witcher_3_wild_hunt_wallpaper),
            PageData(application.getString(R.string.Harley_Quinn), R.drawable.harley_quinn)
        )
    )

    fun switchRecyclerFragmentVisibility(){
        _showMultipleViewRecyclerFragment.value = !_showMultipleViewRecyclerFragment.value!!
    }
}