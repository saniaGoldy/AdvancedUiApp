package com.example.advanceduiapp.model.data

import android.content.Context

data class ToastButtonData(val context: Context, val message:String, override val type: ViewType = ViewType.Button):
    ItemData
