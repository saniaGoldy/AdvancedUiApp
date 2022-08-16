package com.example.advanceduiapp.ui.multiViewRecycler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advanceduiapp.R
import com.example.advanceduiapp.data.ItemData
import com.example.advanceduiapp.data.PageData
import com.example.advanceduiapp.data.TextData

class MultipleViewRecyclerViewModel: ViewModel() {
    private val _itemsData = MutableLiveData(
        listOf(
            PageData(
                "harley",
                R.drawable.harley_quinn
            ),
            TextData("Oi cunt"),

            TextData("wakee wakee"),

            )
    )
    val itemsData: MutableLiveData<List<ItemData>>
        get() = _itemsData
    val toastButtonData = MutableLiveData(listOf(R.string.butcher_greeting, R.string.homelander_phrase))
}