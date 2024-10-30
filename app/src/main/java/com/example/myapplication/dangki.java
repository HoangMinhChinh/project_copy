package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class dangki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutdangki);

        // Tìm kiếm nút Register
        Button btnRegister = findViewById(R.id.btnRegister);

        // Đặt sự kiện OnClick cho nút Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị thông báo "Đăng ký thành công"
                Toast.makeText(dangki.this, "Bạn đã đăng ký thành công", Toast.LENGTH_SHORT).show();

                // Chuyển sang MainActivity sau khi đăng ký
                Intent intent = new Intent(dangki.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
