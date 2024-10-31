package com.example.myapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.myapplication.Adapter.BannerAdapter
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val images = listOf(R.drawable.banner1, R.drawable.banner2)
        val adapter = BannerAdapter(this, images)
        viewPager2.adapter = adapter

        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                val currentItem = viewPager2.currentItem
                viewPager2.currentItem = (currentItem + 1) % images.size
                handler.postDelayed(this, 5000)
            }
        }
        handler.postDelayed(runnable, 5000)
    }
}