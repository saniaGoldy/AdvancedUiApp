package com.example.advanceduiapp.ui.pager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PagerViewModel: ViewModel() {
    val showMultipleViewRecyclerFragment = MutableLiveData<Boolean>(false)
}