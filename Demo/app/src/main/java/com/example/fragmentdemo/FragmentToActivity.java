package com.example.fragmentdemo;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentToActivity extends AppCompatActivity implements FragmentA.OnMessageSendListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_activity);

        // Thêm FragmentA vào Activity nếu chưa có
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FragmentA())
                    .commit();
        }
    }


    @Override
    public void onMessageSend(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
