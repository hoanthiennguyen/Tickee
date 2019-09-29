package com.example.tickee;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmNCFragment extends Fragment {
    int imgId;

    public FilmNCFragment() {
        // Required empty public constructor
    }

    public FilmNCFragment(int imgId) {
        this.imgId = imgId;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film_nc, container, false);
        view.setBackgroundResource(imgId);
        return view;
    }

}
