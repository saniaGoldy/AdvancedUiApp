package com.example.advanceduiapp.ui.multiViewRecycler

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advanceduiapp.R
import com.example.advanceduiapp.model.data.ItemData
import com.example.advanceduiapp.model.data.PageData
import com.example.advanceduiapp.model.data.TextData
import com.example.advanceduiapp.model.data.ToastButtonData

class MultipleViewRecyclerViewModel(application: Application): AndroidViewModel(application) {
    private val appContext get() = getApplication<Application>().applicationContext
    private val _itemsData = MutableLiveData(
        listOf(
            PageData(
                "harley",
                R.drawable.harley_quinn
            ),
            TextData("Oi cunt"),
            ToastButtonData(appContext, appContext.getString(R.string.butcher_greeting)),
            TextData("wakee wakee"),
            ToastButtonData(appContext, appContext.getString(R.string.homelander_phrase))
            )
    )
    val itemsData: MutableLiveData<List<ItemData>>
        get() = _itemsData
}