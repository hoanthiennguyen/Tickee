package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.tabs.TabLayout;

public class FilmScheduleActivity extends AppCompatActivity {
    VideoView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_schedule);
        TabLayout tabLayout = findViewById(R.id.tabTitle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.detailsContainer, new FilmScheduleFragment());
        transaction.commit();
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getText().toString()){
                    case "Lịch chiếu":
                        fragment = new FilmScheduleFragment();
                        break;
                    case "Thông tin":
                        fragment = new FilmInformationFragment();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.detailsContainer, fragment);
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


//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        CinemaShortDescriptionFragment fragment = new CinemaShortDescriptionFragment("BHD","Hai Bà Trưng", "0.5 km");
//        CinemaShortDescriptionFragment fragment2 = new CinemaShortDescriptionFragment("Lotte","Trần Hưng Đạo", "1 km");
//        CinemaShortDescriptionFragment fragment3 = new CinemaShortDescriptionFragment("CNS","Lê Lợi", "2 km");
//        CinemaShortDescriptionFragment fragment4 = new CinemaShortDescriptionFragment("MegaGS","Cống Quỳnh", "2.3 km");
//        CinemaShortDescriptionFragment fragment5 = new CinemaShortDescriptionFragment("Lotte","Hùng Vương", "2.5 km");
//        transaction.add(R.id.cinemaContainer,fragment);
//        transaction.add(R.id.cinemaContainer,fragment2);
//        transaction.add(R.id.cinemaContainer,fragment3);
//        transaction.add(R.id.cinemaContainer,fragment4);
//        transaction.add(R.id.cinemaContainer,fragment5);
//        transaction.commit();



}
