package com.example.yudizapplication.demo_app.Screens

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yudizapplication.R

class HomeScreen : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var btnLight: Button
    private lateinit var btnNight: Button
    private lateinit var fabSettings: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)

        sharedPreferences = getSharedPreferences("Yudiz_sharedPreferences", MODE_PRIVATE)
        btnLight = findViewById(R.id.fab_light)
        btnNight = findViewById(R.id.fab_dark)
        fabSettings = findViewById(R.id.fab_next)

        loadSharedPreferences()

        btnLight.setOnClickListener {
            setLightMode()
            Toast.makeText(this, "Light Mode Enabled", Toast.LENGTH_SHORT).show()
        }

        btnNight.setOnClickListener {
            setDarkMode()
            Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show()
        }

        fabSettings.setOnClickListener {
            setSystemMode()
            Toast.makeText(this, "System Mode Enabled", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun loadSharedPreferences() {
        val isDarkMode = sharedPreferences.getBoolean("nightMode", false)
        val isSystemFollow = sharedPreferences.getBoolean("systemFollow", true)
        when {
            isDarkMode -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            isSystemFollow -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
    private fun setLightMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        saveThemePreferences(isDarkMode = false, isSystemFollow = false)
    }

    private fun setDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        saveThemePreferences(isDarkMode = true, isSystemFollow = false)
    }

    private fun setSystemMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        saveThemePreferences(isDarkMode = false, isSystemFollow = true)
    }

    private fun saveThemePreferences(isDarkMode: Boolean, isSystemFollow: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean("nightMode", isDarkMode)
            putBoolean("systemFollow", isSystemFollow)
            apply()
        }
    }
}
