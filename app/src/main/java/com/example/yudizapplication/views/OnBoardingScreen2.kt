package com.example.yudizapplication.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.OnBoardingScreen
import com.example.yudizapplication.R
import com.example.yudizapplication.activity.FirstScreen
import com.example.yudizapplication.layout.Second_Task
import com.example.yudizapplication.recyclerview.model.PersonInformation
import com.example.yudizapplication.selector.LoginScreen
import com.example.yudizapplication.viewpager.OnBordingViewpager

class OnBoardingScreen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen2)

       var recyclerview = findViewById<Button>(R.id.recyclerView_Btn)
       var fab_btn_back = findViewById<View>(R.id.fab_btn_back)

        recyclerview.setOnClickListener {
            intent = Intent(applicationContext, PersonInformation::class.java)
            startActivity(intent)
        }

        fab_btn_back.setOnClickListener {
            intent = Intent(applicationContext, OnBoardingScreen::class.java)
            startActivity(intent)
        }

    }
}
