package com.example.tickee.filmschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.example.tickee.BookTicketActivity;
import com.example.tickee.R;
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



    public void onClickFilmTime(View view){
        Intent intent = new Intent(this, BookTicketActivity.class);
        startActivity(intent);
    }






}
