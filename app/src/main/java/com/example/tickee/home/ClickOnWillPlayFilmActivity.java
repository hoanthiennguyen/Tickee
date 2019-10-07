package com.example.tickee.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tickee.R;

public class ClickOnWillPlayFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_on_will_play_film);
    }
    public void onClickSubmit(View view){
        finish();
    }
}
