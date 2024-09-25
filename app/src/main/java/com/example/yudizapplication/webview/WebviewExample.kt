package com.example.yudizapplication.webview

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R
import org.w3c.dom.Text

class WebviewExample : AppCompatActivity() {

    lateinit var webview : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_example)
        webview = findViewById(R.id.webview)
        val btn_tap_youtube = findViewById<Button>(R.id.btn_tap_YOUTUBE)
        val btn_tap_html = findViewById<Button>(R.id.btn_tap_html)
        val para: String = getString(R.string.HTML_text)

        val temp: Boolean = true
        btn_tap_youtube.setOnClickListener {
            webview.webViewClient = WebViewClient()
            webview.loadUrl("https://www.google.com/")
            webview.settings.javaScriptEnabled = true
            webview.settings.setSupportZoom(true)
            btn_tap_youtube.setText("TAP TO REFRESH")
            if (!temp){
                btn_tap_youtube.visibility = View.VISIBLE
            }else{
                btn_tap_html.visibility = View.INVISIBLE
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
}