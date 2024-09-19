package com.example.yudizapplication.viewpager

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.yudizapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class WeatherInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info)



        val daysWithImages = listOf(
            Pair("Sunday: Wind,31°C", R.drawable.wind),
            Pair("Monday: Cloudy, 32°C", R.drawable.sunny_cloud),
            Pair("Tuesday: Wind,31°C", R.drawable.wind),
            Pair("Wednesday: Cloudy,30°C", R.drawable.sunny_cloud),
            Pair("Thursday: Cloudy,30°C", R.drawable.sunny_cloud),
            Pair("Friday: Wind,31°C", R.drawable.wind),
            Pair("Saturday: Cloudy,31°C", R.drawable.sunny_cloud),
        )

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val adapter = WeatherPagerAdapter(this, daysWithImages)
        viewPager.adapter = adapter

        // Link the TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = daysWithImages[position].first // Use the day name for tab title
        }.attach()
    }
}