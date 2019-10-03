package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tickee.cinema.ListCinema;
import com.example.tickee.cinema.NearCinema;
import com.google.android.material.tabs.TabLayout;

public class CinemaActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);



        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragment

        adapter.AddFragment(new NearCinema(),"Near Cinema");
        adapter.AddFragment(new ListCinema(),"List Cinema");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }



}
