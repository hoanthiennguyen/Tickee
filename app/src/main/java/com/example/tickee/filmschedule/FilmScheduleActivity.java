package com.example.tickee.filmschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.tickee.BookTicketActivity;
import com.example.tickee.HomeActivity;
import com.example.tickee.R;
import com.example.tickee.SelectChairActivity;
import com.google.android.material.tabs.TabLayout;

public class FilmScheduleActivity extends AppCompatActivity {
    VideoView mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_schedule);
        TabLayout tabLayout = findViewById(R.id.tabTitle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment beginFragment;
        if(getIntent().getBooleanExtra("cinemaWasChosen", false)){
            beginFragment = new FilmInformationFragment();
            tabLayout.getTabAt(1).select();
        }
        else
            beginFragment = new FilmScheduleFragment();
        transaction.replace(R.id.detailsContainer, beginFragment);
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


    public void onClickExit(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void onClickFilmTime(View view){
        Intent intent = new Intent(this, SelectChairActivity.class);
        startActivity(intent);
    }
    public void onClickPlayTrailer(View view){
        mPlayer = findViewById(R.id.trailerFilm);
        if (mPlayer.isPlaying()) {
            view.setVisibility(View.VISIBLE);
            mPlayer.pause();
        } else {
            mPlayer.start();
            // hide button once playback starts
            view.setVisibility(View.INVISIBLE);
        }
    }

    public void onClickBookTicketOnFilmInformation(View view) {

        Intent intent = new Intent(this, FilmScheduleActivity.class);
        startActivity(intent);

    }








}
