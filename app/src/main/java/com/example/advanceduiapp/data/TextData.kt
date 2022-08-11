package com.example.advanceduiapp.data

data class TextData(val text: String): ItemData {
    override fun getType() = 1
}
