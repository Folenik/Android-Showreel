package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.Const.WEBVIEW_PAGE_URL
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        setupWebView()
    }

    private fun setupWebView() {
        webview.apply {
            this.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    webview.loadUrl("javascript: (function() {" +
                            "document.getElementById('hplogo').style.display='none';"+
                            "document.getElementById('footer').style.display='none';"+
                            "})()")
                }
                
            }
            this.loadUrl(WEBVIEW_PAGE_URL)
        }

        webview.settings.apply {
            this.javaScriptEnabled = true
            this.javaScriptCanOpenWindowsAutomatically = true
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, WebViewActivity::class.java)
    }

}