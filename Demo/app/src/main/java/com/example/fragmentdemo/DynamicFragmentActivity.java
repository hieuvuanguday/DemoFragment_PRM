package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DynamicFragmentActivity extends AppCompatActivity {
    private Button btnAddFragment;
    private boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        btnAddFragment = findViewById(R.id.btnAddFragment);
        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayed) {
                    addFragment();
                    btnAddFragment.setText("Remove Fragment");
                } else {
                    removeFragment();
                    btnAddFragment.setText("Add Fragment");
                }
                isFragmentDisplayed = !isFragmentDisplayed;
            }
        });
    }

    private void addFragment() {
        DynamicFragment dynamicFragment = new DynamicFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, dynamicFragment); // Sửa từ add() thành replace()
        fragmentTransaction.addToBackStack(null); // Thêm vào BackStack để có thể quay lại
        fragmentTransaction.commit();
    }


    private void removeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
            fragmentManager.popBackStack(); // Xóa Fragment khỏi BackStack
        }
    }

}
