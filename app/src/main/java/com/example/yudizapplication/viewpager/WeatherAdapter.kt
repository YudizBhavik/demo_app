package com.example.yudizapplication.viewpager

import android.widget.ImageView
import com.example.weatherapp.DayFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class WeatherPagerAdapter(

activity: FragmentActivity, private val daysWithImages: List<Pair<String, Int>>) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = daysWithImages.size

    override fun createFragment(position: Int): Fragment {
        val (day, imageResId) = daysWithImages[position]
        return DayFragment.newInstance(day, imageResId)
    }
}
