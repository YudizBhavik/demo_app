package com.example.yudizapplication.viewpager.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.yudizapplication.R
import com.example.yudizapplication.viewpager.fragment.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RecipeScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_screen2)
        val viewPager2 = findViewById<ViewPager2>(R.id.my_view_Page)
        val tabLayout = findViewById<TabLayout>(R.id.my_tab_layout)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        viewPager2.setCurrentItem(1, false)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 4) {
                    viewPager2.post { viewPager2.setCurrentItem(1, false) }
                }
                else if (position == 0) {
                    viewPager2.post { viewPager2.setCurrentItem(3, false) }
                }
            }
        })
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                1 -> tab.text = "BREAKFAST"
                2 -> tab.text = "LAUNCH"
                3 -> tab.text = "DINNER"
            }
        }.attach()
    }
}