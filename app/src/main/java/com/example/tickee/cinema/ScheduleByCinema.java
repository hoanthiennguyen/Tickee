package com.example.tickee.cinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tickee.BookTicketActivity;
import com.example.tickee.R;
import com.google.android.material.tabs.TabLayout;

public class ScheduleByCinema extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_by_cinema);

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.scheduleDetail, new CinemaSchedule());
        transaction.commit();

    }

    public void onClickBookTiket(View view){
        Intent intent = new Intent(this, BookTicketActivity.class);
        startActivity(intent);
    }

    public void onClickExitCinema(View view){
        finish();
    }
}
