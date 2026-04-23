package com.daviti.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.daviti.portfolio.adapters.ViewPagerAdapter

/**
 * Single Activity — ყველა ფრაგმენტი ViewPager2-ში
 * გვარი: ამირანაშვილი — იწყება ხმოვანზე „ა" → HORIZONTAL ორიენტაცია
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val daliViewpager  = findViewById<ViewPager2>(R.id.dali_viewpager)
        val daliTablayout  = findViewById<TabLayout>(R.id.dali_tablayout)

        // Dynamic Orientation: გვარი „ამირანაშვილი" → ხმოვანი „ა" → Horizontal
        daliViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        daliViewpager.adapter = ViewPagerAdapter(this)

        val tabTitles = listOf("შეყვანა", "ანალიტიკა", "პროფილი")
        TabLayoutMediator(daliTablayout, daliViewpager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
