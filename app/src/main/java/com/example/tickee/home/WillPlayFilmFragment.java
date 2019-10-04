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
public class WillPlayFilmFragment extends Fragment {
    int imgId;
    float rating;
    String date,ageRequired;
    public WillPlayFilmFragment() {
        // Required empty public constructor
    }

    public WillPlayFilmFragment(int imgId, float rating, String date, String ageRequired) {
        this.imgId = imgId;
        this.rating = rating;
        this.date = date;
        this.ageRequired = ageRequired;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_will_play_film, container, false);
        ImageView imageView = view.findViewById(R.id.roundedImageView);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        TextView txtDateToBeShowed = view.findViewById(R.id.txtDateToBeShowed);
        TextView txtAgeRequired = view.findViewById(R.id.txtAgeRequired);

        imageView.setImageResource(imgId);
        ratingBar.setRating(rating);
        txtDateToBeShowed.setText(date);
        if(ageRequired == null)
            txtAgeRequired.setVisibility(View.INVISIBLE);
        else{
            txtAgeRequired.setVisibility(View.VISIBLE);
            txtAgeRequired.setText(ageRequired);
        }
        return view;
    }

}
