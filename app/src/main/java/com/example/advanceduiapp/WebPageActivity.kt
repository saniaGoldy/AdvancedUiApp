package com.example.advanceduiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        setContentView(webView)
        supportActionBar?.title = getString(R.string.menu_web_page)
        webView.loadUrl("https://developer.android.com/")
    }
}