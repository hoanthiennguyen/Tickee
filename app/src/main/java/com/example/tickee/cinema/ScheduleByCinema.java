package com.example.tickee.cinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tickee.R;
import com.google.android.material.tabs.TabLayout;

public class ScheduleByCinema extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_by_cinema);
        TabLayout tabLayout = findViewById(R.id.tabSchedule);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.scheduleDetail, new CinemaSchedule());
        transaction.commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getText().toString()){
                    case "Lịch Chiếu":
                        fragment = new CinemaSchedule();
                        break;
                    case "Thông tin":
                        break;
                }
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.scheduleDetail,fragment);
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
