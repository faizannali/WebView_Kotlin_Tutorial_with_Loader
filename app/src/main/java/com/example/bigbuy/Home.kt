package com.example.bigbuy

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    private val webUrl = "https://www.big-buy.in/"
    private var webView:WebView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        webView=findViewById(R.id.webView)
        //webView.loadUrl(weburl)

        //webView.webViewClient = WebViewClientImpl(this)
        webView?.settings?.javaScriptEnabled = true

        val webViewClient = WebViewClientImpl(this)
        webView?.webViewClient = webViewClient

        webView?.loadUrl(webUrl)

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.webView!!.canGoBack()) {
            showProgressBar()
            this.webView?.goBack()
            hideProgressBar()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


    private fun showProgressBar(){
        progressBar1.visibility= View.VISIBLE
    }
    private fun hideProgressBar(){
        progressBar1.visibility= View.GONE
    }



}