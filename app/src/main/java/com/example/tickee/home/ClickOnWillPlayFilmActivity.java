package com.example.tickee.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.tickee.R;

public class ClickOnWillPlayFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_on_will_play_film);
    }
    public void onClickSubmit(View view){
        Toast.makeText(this, "Đăng ký nhận thông báo thành công!", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void onClickPlayTrailer(View view){
        VideoView mPlayer = findViewById(R.id.trailerFilm);
        if (mPlayer.isPlaying()) {
            view.setVisibility(View.VISIBLE);
            mPlayer.pause();
        } else {
            mPlayer.start();
            // hide button once playback starts
            view.setVisibility(View.INVISIBLE);
        }
    }
}
