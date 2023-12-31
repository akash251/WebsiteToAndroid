package com.websitetoandroid

import android.net.Uri
import android.webkit.ConsoleMessage
import android.webkit.ValueCallback
import android.webkit.WebView
import com.google.accompanist.web.AccompanistWebChromeClient


class CustomWebChromeClient(private val onFileChooserCallback: (ValueCallback<Array<Uri>>?,FileChooserParams?) -> Unit) : AccompanistWebChromeClient() {




    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {

        return true
    }

    override fun onShowFileChooser(
        webView: WebView?,
        filePathCallback: ValueCallback<Array<Uri>>?,
        fileChooserParams: FileChooserParams?
    ): Boolean {
        onFileChooserCallback.invoke(filePathCallback,fileChooserParams)
        return true
    }


}