package com.example.yudizapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.activity.FirstScreen
import com.example.yudizapplication.layout.Second_Task
import com.example.yudizapplication.selector.LoginScreen
import com.example.yudizapplication.viewpager.OnBordingViewpager
import com.example.yudizapplication.viewpager.WeatherInfo
import com.example.yudizapplication.views.OnBoardingScreen2
import com.example.yudizapplication.views.RegistrationForm
import com.google.android.material.snackbar.Snackbar

class OnBoardingScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen)


       var activity = findViewById<Button>(R.id.btn_activity)
       var layout = findViewById<Button>(R.id.btn_layout)
       var views = findViewById<Button>(R.id.btn_view)
       var selector = findViewById<Button>(R.id.btn_selector)
       var viewpagger = findViewById<Button>(R.id.btn_viewpagger)
       var fab_btn = findViewById<View>(R.id.fab_btn_next)

        activity.setOnClickListener {
            intent = Intent(applicationContext, FirstScreen::class.java)
            startActivity(intent)
        }
        layout.setOnClickListener {
            intent = Intent(applicationContext, Second_Task::class.java)
            startActivity(intent)
        }
        views.setOnClickListener {
            intent = Intent(applicationContext, RegistrationForm::class.java)
            startActivity(intent)
        }
        selector.setOnClickListener {
            intent = Intent(applicationContext, LoginScreen::class.java)
            startActivity(intent)
        }
        viewpagger.setOnClickListener {
            intent = Intent(applicationContext, OnBordingViewpager::class.java)
            startActivity(intent)
        }

        fab_btn.setOnClickListener {
            intent = Intent(applicationContext, OnBoardingScreen2::class.java)
            startActivity(intent)
        }

    }
}
