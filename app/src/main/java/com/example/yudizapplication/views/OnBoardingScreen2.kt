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
import com.example.yudizapplication.dialog.AddUserScreen
import com.example.yudizapplication.exp_menu.ContextScreen
import com.example.yudizapplication.fontExample.FontScreen
import com.example.yudizapplication.recyclerview.model.PersonInformation
import com.example.yudizapplication.snackbar.SnackbarScreen

class OnBoardingScreen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_boarding_screen2)

    }
}
