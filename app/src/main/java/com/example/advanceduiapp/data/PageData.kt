package com.example.advanceduiapp.data

data class PageData(val title:String,val resourceId: Int): ItemData {
    override fun getType() = DataTypes.Page
}
