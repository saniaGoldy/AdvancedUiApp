package com.example.advanceduiapp.ui.slideshow

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PagerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "CyberCiri"
    }
    val title: LiveData<String> = _text
}