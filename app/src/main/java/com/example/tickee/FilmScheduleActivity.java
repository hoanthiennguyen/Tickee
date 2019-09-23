package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FilmScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_schedule);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
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
    public void onClickShowMore(View view){
        Toast.makeText(this, "view " + view.getId(), Toast.LENGTH_SHORT).show();
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup parent = findViewById(view.getId());
        parent.setMinimumHeight(70);
        inflater.inflate(R.layout.movie_time_at_theater, parent);
    }
}
