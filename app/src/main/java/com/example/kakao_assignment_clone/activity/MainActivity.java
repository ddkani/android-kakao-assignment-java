package com.example.kakao_assignment_clone.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.kakao_assignment_clone.R;
import com.example.kakao_assignment_clone.databinding.ActivityMainBinding;
import com.example.kakao_assignment_clone.fragment.BookmarkFragment;
import com.example.kakao_assignment_clone.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentManager fragmentManager = getSupportFragmentManager();

    SearchFragment searchFragment = new SearchFragment();
    BookmarkFragment bookmarkFragment = new BookmarkFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager.beginTransaction().replace(
                R.id.menu_frame_layout, searchFragment).commitNowAllowingStateLoss();

        binding.menuBottomNavigation.setOnItemSelectedListener(menuItem -> {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            final int currentMenuId = menuItem.getItemId();

            if (currentMenuId == R.id.menu_search) {
                transaction.replace(R.id.menu_frame_layout, searchFragment).commitAllowingStateLoss();
            } else if (currentMenuId == R.id.menu_bookmark) {
                transaction.replace(R.id.menu_frame_layout, bookmarkFragment).commitAllowingStateLoss();
            } else {
                transaction.commit();
                return false;
            }

            return true;
        });
    }
}