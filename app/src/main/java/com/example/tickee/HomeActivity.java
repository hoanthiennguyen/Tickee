package com.example.tickee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBar);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_news:
                        intent = new Intent(HomeActivity.this, NewsActivity.class);
                        break;
                    case R.id.nav_cinema:
                        intent = new Intent(HomeActivity.this, CinemaActivity.class);
                        break;
                    case R.id.nav_home:
                        intent = new Intent(HomeActivity.this, HomeActivity.class);
                        break;
                    case R.id.nav_account:
                        intent = new Intent(HomeActivity.this, AccountActivity.class);
                        break;

                }
                startActivity(intent);
                return true;
            }
        });
    }

}
