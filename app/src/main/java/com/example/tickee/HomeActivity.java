package com.example.tickee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class    HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_news:
                        fragment = new NewsFragment();
                        break;
                    case R.id.nav_cinema:
                        fragment = new CinemaFragment();
                        break;
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_account:
                        fragment = new AccountFragment();
                        break;

                }
                transaction.replace(R.id.fragmentContainer, fragment);
                transaction.commit();
                return true;
            }
        });
    }
    public void onClickFilm(View view){
        Intent intent = new Intent(this, FilmScheduleActivity.class);
        startActivity(intent);
    }

}
