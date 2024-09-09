package com.example.yudizapplication.viewpager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.yudizapplication.R
import com.example.yudizapplication.RecipePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RecipeScreen : AppCompatActivity() {

        private lateinit var viewPager: ViewPager2
        private lateinit var tabLayout: TabLayout

        var list = listOf("Breakfast","Launch","Dinner")

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_recipe_screen)

            viewPager = findViewById(R.id.viewPager)
            tabLayout = findViewById(R.id.tabLayout)

            val pagerAdapter = RecipePagerAdapter(this)
            viewPager.adapter = pagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = list[position]
            }.attach()
        }
}