package com.example.yudizapplication.viewpager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R
import com.example.yudizapplication.activity.FirstScreen
import com.example.yudizapplication.layout.Second_Task
import com.example.yudizapplication.viewpager.fragment.RecipeScreen2

class OnBordingViewpager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_on_bording_viewpager)

        lateinit var weather : Button
        lateinit var recipe: Button

        weather = findViewById(R.id.weather)
        recipe = findViewById(R.id.recipe)

        weather.setOnClickListener {
            intent = Intent(applicationContext, WeatherInfo::class.java)
            startActivity(intent)
        }
        recipe.setOnClickListener {
            intent = Intent(applicationContext, RecipeScreen2::class.java)
            startActivity(intent)
        }
    }
}