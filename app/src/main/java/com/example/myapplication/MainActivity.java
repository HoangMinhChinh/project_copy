package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Thay bằng layout của bạn

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2); // Thay bằng ID của ViewPager2 trong layout của bạn
        List<Integer> images = Arrays.asList(R.drawable.banner1, R.drawable.banner2); // Thay bằng các drawable của bạn
        BannerAdater adapter = new BannerAdater(this, images);
        viewPager2.setAdapter(adapter);

        // Tự động cuộn banner (tùy chọn)
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager2.getCurrentItem();
                viewPager2.setCurrentItem((currentItem + 1) % images.size());
                handler.postDelayed(this, 5000); // Chạy lại sau 3 giây
            }
        };
        handler.postDelayed(runnable, 5000);
    }
}