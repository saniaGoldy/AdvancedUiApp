package com.example.advanceduiapp.data

data class PageData(val title:String, val resourceId: Int, override val type: ViewType = ViewType.Page): ItemData
