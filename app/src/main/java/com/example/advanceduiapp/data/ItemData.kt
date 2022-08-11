package com.example.advanceduiapp.data

abstract interface ItemData {
    /**
    @returns typeOfItem 0 for PageData, 1 for TextData, 2 for ToastButtonData
     */
    abstract fun getType(): Int
}