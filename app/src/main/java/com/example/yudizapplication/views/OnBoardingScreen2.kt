package com.example.yudizapplication.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.yudizapplication.OnBoardingScreen
import com.example.yudizapplication.R
import com.example.yudizapplication.coordinator.CoordinatorScreen
import com.example.yudizapplication.exp_menu.ContextScreen
import com.example.yudizapplication.fontExample.FontScreen
import com.example.yudizapplication.recyclerview.model.PersonInformation
import com.example.yudizapplication.snackbar.SnackbarScreen

class OnBoardingScreen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen2)

       val recyclerview = findViewById<Button>(R.id.recyclerView_Btn)
       val btn_coordinator = findViewById<Button>(R.id.btn_coordinator)
       val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
       val btn_font = findViewById<Button>(R.id.btn_font)
       val btn_context_menu = findViewById<Button>(R.id.menu)
       val fab_btn_back = findViewById<View>(R.id.fab_btn_back)

        recyclerview.setOnClickListener {
            intent = Intent(applicationContext, PersonInformation::class.java)
            startActivity(intent)
        }
        btn_coordinator.setOnClickListener {
            intent = Intent(applicationContext, CoordinatorScreen::class.java)
            startActivity(intent)
        }
        btn_snackbar.setOnClickListener {
            intent = Intent(applicationContext, SnackbarScreen::class.java)
            startActivity(intent)
        }
        btn_font.setOnClickListener {
                    intent = Intent(applicationContext, FontScreen::class.java)
                    startActivity(intent)
                }
        btn_context_menu.setOnClickListener {
                    intent = Intent(applicationContext, ContextScreen::class.java)
                    startActivity(intent)
                }

        fab_btn_back.setOnClickListener {
            intent = Intent(applicationContext, OnBoardingScreen::class.java)
            startActivity(intent)
        }

    }
}
