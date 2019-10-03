package com.example.tickee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.tickee.cinema.CinemaFragment;
import com.example.tickee.filmschedule.FilmScheduleActivity;
import com.example.tickee.home.ClickOnDCFilmActivity;
import com.example.tickee.home.ClickOnSCFilmActivity;
import com.example.tickee.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class    HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBar);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = new HomeFragment();
        transaction.replace(R.id.fragmentContainer,fragment);
        transaction.commit();
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
    }public void onClickStoppedPlayFilm(View view){
        Intent intent = new Intent(this, ClickOnDCFilmActivity.class);
        startActivity(intent);
    }
    public void onClickSCFilm(View view){
        Intent intent = new Intent(this, ClickOnSCFilmActivity.class);
        startActivity(intent);
    }
    public void onClickNew(View view) {
        Intent intent = new Intent(this, ClickOnNewActivity.class);
        startActivity(intent);
    }

}
