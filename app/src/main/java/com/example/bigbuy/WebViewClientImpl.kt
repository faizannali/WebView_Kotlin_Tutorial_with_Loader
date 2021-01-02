package com.example.bigbuy

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast


class WebViewClientImpl(activity: Activity?) : WebViewClient() {
    private var activity: Activity? = null
    val progressBar=activity?.findViewById<ProgressBar>(R.id.progressBar1)
    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        if (url.indexOf("big-buy.in") > -1) return false
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        activity!!.startActivity(intent)
        return true
    }

    init {
        this.activity = activity
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        progressBar?.visibility= View.VISIBLE
        //Toast.makeText(this.activity,"started",Toast.LENGTH_LONG).show()
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        progressBar?.visibility= View.GONE
        //Toast.makeText(this.activity,"Finished",Toast.LENGTH_LONG).show()
        super.onPageFinished(view, url)
    }
}

