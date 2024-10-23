package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class introActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button startBtn = findViewById(R.id.startBtn); // 1
        startBtn.setOnClickListener(new View.OnClickListener() { // 2
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(introActivity.this, dangki.class); // 3
                startActivity(intent); // 4
            }
        });

        TextView textView3 = findViewById(R.id.textView3); // Lấy TextView bằng id
        textView3.setOnClickListener(new View.OnClickListener() { // Bắt sự kiện click
            @Override
            public void onClick(View v) {
                // Chuyển sang activity_layoutdangnhap khi bấm vào textview3
                Intent intent = new Intent(introActivity.this,dangnhap.class); // Tên activity đăng nhập
                startActivity(intent);
            }
        });
    }
}