package com.example.gymmangement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_menu extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_bottom_menu);



        replaceFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.shorts:
                    replaceFragment(new ShortsFragment());
                    break;

                case R.id.subscriptions:
                    replaceFragment(new SubscriptionFragment());
                    break;

                case R.id.library:
                    replaceFragment(new LibraryFragment());
                    break;
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
