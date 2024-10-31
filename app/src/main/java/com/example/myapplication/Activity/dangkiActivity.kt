package com.example.myapplication.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class dangkiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layoutdangki)

        // Tìm kiếm nút Register
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // Đặt sự kiện OnClick cho nút Register
        btnRegister.setOnClickListener {
            // Hiển thị thông báo "Đăng ký thành công"
            Toast.makeText(this, "Bạn đã đăng ký thành công", Toast.LENGTH_SHORT).show()

            // Chuyển sang MainActivity sau khi đăng ký
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}