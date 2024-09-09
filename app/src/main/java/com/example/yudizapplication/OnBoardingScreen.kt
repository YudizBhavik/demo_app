package com.example.yudizapplication

import android.content.Intent
import android.os.Bundle
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
import com.example.yudizapplication.views.RegistrationForm

class OnBoardingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen)

        lateinit var activity : Button
        lateinit var layout: Button
        lateinit var views: Button
        lateinit var selector: Button
        lateinit var viewpagger: Button


        activity = findViewById(R.id.activity)
        layout = findViewById(R.id.layout)
        views = findViewById(R.id.view)
        selector = findViewById(R.id.selector)
        viewpagger = findViewById(R.id.viewpagger)

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

    }
}
