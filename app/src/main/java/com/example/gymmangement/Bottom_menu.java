package com.example.gymmangement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;

import com.example.gymmangement.databinding.ActivityMainBinding;

public class Bottom_menu extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.


        binding.bottomNavigationView.setOnSelectedListener(item -> {

            switch (item.getitemid()) {
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
