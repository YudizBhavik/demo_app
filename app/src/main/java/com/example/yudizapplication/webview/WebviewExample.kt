package com.example.yudizapplication.webview

import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.window.OnBackInvokedDispatcher
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.example.yudizapplication.R
import org.w3c.dom.Text

class WebviewExample : AppCompatActivity() {

    lateinit var webview : WebView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_example)
        webview = findViewById(R.id.webview)
        val btn_tap_youtube = findViewById<Button>(R.id.btn_tap_YOUTUBE)
        val btn_tap_html = findViewById<Button>(R.id.btn_tap_html)
        val para: String = getString(R.string.HTML_text)
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(webview.settings, WebSettingsCompat.FORCE_DARK_ON)
            WebSettingsCompat.setAlgorithmicDarkeningAllowed(webview.settings,true)
        }
        val temp: Boolean = true
        btn_tap_youtube.setOnClickListener {

            webview.webViewClient = WebViewClient()
            webview.loadUrl("https://medium.com/droid-log/webview-darkening-force-dark-mode-for-web-contents-d76d86ff9efa")
            webview.settings.javaScriptEnabled = true
            webview.settings.textZoom
            webview.settings.cursiveFontFamily
            webview.settings.setSupportZoom(true)
            btn_tap_youtube.setText("TAP TO REFRESH")
            if (!temp){
                btn_tap_youtube.visibility = View.INVISIBLE
            }else{
                btn_tap_html.visibility = View.INVISIBLE
                btn_tap_youtube.visibility = View.VISIBLE
            }
        }
        btn_tap_html.setOnClickListener {
            webview.webViewClient = WebViewClient()
            webview.loadData(para,"text/html","UTF-8")
            webview.settings.javaScriptEnabled = true
            if (!temp){
                btn_tap_html.visibility = View.VISIBLE
            }else{
                btn_tap_youtube.visibility = View.INVISIBLE
                btn_tap_html.visibility = View.INVISIBLE
            }
        }

    }

    override fun onBackPressed() {
        if (webview.canGoBack()){
            webview.goBack()
        }else {
            super.onBackPressed()
        }
    }
}