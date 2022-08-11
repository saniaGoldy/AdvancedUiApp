package com.example.advanceduiapp.data

import android.content.Context

data class ToastButtonData(val context: Context,val message:String): ItemData {
    override fun getType() = DataTypes.Button
}
