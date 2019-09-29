package com.example.tickee.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tickee.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmSCFragment extends Fragment {
    int imgId;

    public FilmSCFragment() {
        // Required empty public constructor
    }

    public FilmSCFragment(int imgId) {
        this.imgId = imgId;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film_sc, container, false);
        ImageView imageView = view.findViewById(R.id.roundedImageView);
        imageView.setImageResource(imgId);
        return view;
    }

}
