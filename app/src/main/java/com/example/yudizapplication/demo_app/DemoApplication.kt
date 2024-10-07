package com.example.yudizapplication.demo_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R
import com.example.yudizapplication.Workmanager.WorkManagerSecondExample
import com.example.yudizapplication.demo_app.Screens.HomeScreen
import com.example.yudizapplication.demo_app.Screens.WebViewDarkMode

class DemoApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_demo_application)

        val btn_demoapk = findViewById<Button>(R.id.btn_demo_apk_start)
        val btn_web_demoapk = findViewById<Button>(R.id.btn_web_demo_apk_start)

        btn_demoapk.setOnClickListener {
            intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
        btn_web_demoapk.setOnClickListener {
            intent = Intent(this, WebViewDarkMode::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}