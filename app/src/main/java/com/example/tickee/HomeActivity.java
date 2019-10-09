package com.example.tickee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.tickee.cinema.CinemaFragment;
import com.example.tickee.cinema.ScheduleByCinemaActivity;
import com.example.tickee.filmschedule.FilmScheduleActivity;
import com.example.tickee.home.ClickOnPlayedFilmActivity;
import com.example.tickee.home.ClickOnWillPlayFilmActivity;
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
                    case R.id.nav_cinema:
                        fragment = new CinemaFragment();
                        break;
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_account:
                        fragment = new AccountFragment();
                        break;
                    case R.id.nav_notification:
                        fragment = new NotificationFragment();
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
        Intent intent = new Intent(this, ClickOnPlayedFilmActivity.class);
        startActivity(intent);
    }
    public void onClickSCFilm(View view){
        Intent intent = new Intent(this, ClickOnWillPlayFilmActivity.class);
        startActivity(intent);
    }
    public void onClickNew(View view) {
        Intent intent = new Intent(this, ClickOnNewActivity.class);
        startActivity(intent);
    }

    public void onClickLogout(View view){
        new AlertDialog.Builder(this)
                .setMessage("Bạn chắc chắn muốn đăng xuất?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Không", null)
                .show();
    }
    public void onClickTransactionHistory(View view){
        Intent intent = new Intent(this, TransactionHistoryActivity.class);
        startActivity(intent);
    }
    public void onClickCinema(View view){
        Intent intent = new Intent(this, ScheduleByCinemaActivity.class);
        startActivity(intent);

    }
    public void onClickDiscount(View view){
        Intent intent = new Intent(this, DiscountActivity.class);
        startActivity(intent);

    }


}
