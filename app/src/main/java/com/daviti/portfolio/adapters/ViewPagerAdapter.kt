package com.daviti.portfolio.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.daviti.portfolio.fragments.AnalyticsFragment
import com.daviti.portfolio.fragments.InputFragment
import com.daviti.portfolio.fragments.ProfileFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> InputFragment()
        1 -> AnalyticsFragment()
        2 -> ProfileFragment()
        else -> InputFragment()
    }
}
