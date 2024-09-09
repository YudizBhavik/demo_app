package com.example.yudizapplication.viewpager.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.yudizapplication.viewpager.fragment.BreakfastFragment
import com.example.yudizapplication.viewpager.fragment.DinnerFragment
import com.example.yudizapplication.viewpager.fragment.LaunchFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BreakfastFragment()
            1 -> BreakfastFragment()
            2 -> LaunchFragment()
            3 -> DinnerFragment()
            else -> Fragment()
        }
    }
}
