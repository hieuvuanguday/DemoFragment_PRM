package com.example.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các nút
        Button btnStaticFragment = findViewById(R.id.btnStaticFragment);
        Button btnDynamicFragment = findViewById(R.id.btnDynamicFragment);
        Button btnFragmentToActivity = findViewById(R.id.btnFragmentToActivity);

        // Xử lý sự kiện nhấn
        btnStaticFragment.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StaticFragmentActivity.class);
            startActivity(intent);
        });

        btnDynamicFragment.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DynamicFragmentActivity.class);
            startActivity(intent);
        });

        btnFragmentToActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FragmentToActivity.class);
            startActivity(intent);
        });
    }
}
