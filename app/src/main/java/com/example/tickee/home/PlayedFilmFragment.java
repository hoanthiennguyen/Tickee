package com.example.tickee.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.example.tickee.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayedFilmFragment extends Fragment {
    int imgId;
    float rating;

    public PlayedFilmFragment() {
        // Required empty public constructor
    }

    public PlayedFilmFragment(int imgId, float rating) {
        this.imgId = imgId;
        this.rating = rating;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_played_film, container, false);
        ImageView imageView = view.findViewById(R.id.roundedImageView);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setRating(rating);
        imageView.setImageResource(imgId);
        return view;
    }

}
