package com.example.tickee.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tickee.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayingFilmFragment extends Fragment {
    int imgId;
    String ageRequired;
    float rating;
    public PlayingFilmFragment() {
        // Required empty public constructor
    }

    public PlayingFilmFragment(int imgId, String ageRequired, float rating) {
        this.imgId = imgId;
        this.ageRequired = ageRequired;
        this.rating = rating;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film, container, false);
        ImageView imageView = view.findViewById(R.id.roundedImageView);
        TextView txtAgeRequired = view.findViewById(R.id.txtAgeRequired);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        if(ageRequired == null)
            txtAgeRequired.setVisibility(View.INVISIBLE);
        else{
            txtAgeRequired.setVisibility(View.VISIBLE);
            txtAgeRequired.setText(ageRequired);
        }
        ratingBar.setRating(rating);
        imageView.setImageResource(imgId);
        return view;
    }

}
