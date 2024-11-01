package com.example.myapplication.Activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Adapter.BannerAdapter
import com.example.myapplication.Adapter.all_book_Adapter
import com.example.myapplication.R
import com.example.myapplication.ViewModel.DashboardQLSModel
import com.example.myapplication.databinding.DashboardQlsBinding // Sửa tên lớp binding

class dashboard_qls_Activity : AppCompatActivity() {

    private lateinit var binding: DashboardQlsBinding // Sửa tên binding
    private val viewModel = DashboardQLSModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DashboardQlsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init_allBook()

        binding = DashboardQlsBinding.inflate(layoutInflater) // Sửa tên binding
        setContentView(binding.root)

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

    private fun init_allBook() {
        // Hiển thị RecyclerView trước khi cập nhật dữ liệu (nếu muốn)
        binding.viewAllBook.visibility = View.VISIBLE

        viewModel.categories.observe(this) { categories ->
            // Cập nhật dữ liệu cho RecyclerView
            binding.viewAllBook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.viewAllBook.adapter = all_book_Adapter(categories)

            // Ẩn RecyclerView nếu cần thiết (ví dụ: sau khi có lỗi hoặc không có dữ liệu)
            binding.viewAllBook.visibility = View.GONE
        }
        viewModel.loadview_all_book()
    }
}