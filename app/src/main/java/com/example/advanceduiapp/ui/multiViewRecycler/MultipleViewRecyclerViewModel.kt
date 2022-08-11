package com.example.advanceduiapp.ui.multiViewRecycler

import androidx.lifecycle.ViewModel
import com.example.advanceduiapp.R
import com.example.advanceduiapp.data.PageData
import com.example.advanceduiapp.data.TextData
import com.example.advanceduiapp.data.ToastButtonData

class MultipleViewRecyclerViewModel: ViewModel() {
    val itemsData
        get() = listOf(
            PageData(
                "harley",
                R.drawable.harley_quinn___valentine_s_day_lingerie_by_hugotendaz_on_deviantart
            ),
            TextData("Oi cunt"),

            TextData("wakee wakee"),

        )
}