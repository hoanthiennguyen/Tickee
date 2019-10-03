package com.example.tickee.cinema;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tickee.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NearCinema extends Fragment {
    View v;
    private RecyclerView myRecyclerView;
    private List<CinemaModel> listCinema;

    public NearCinema() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_near_cinema, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.near_recycleview);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(), listCinema);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recycleViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listCinema = new ArrayList<>();
        listCinema.add(new CinemaModel("Galaxy Quang Trung", "304 Quang Trung", "6 km",R.drawable.galaxy));
        listCinema.add(new CinemaModel("BHD Quang Trung", "231 Quang Trung", "5.6 km",R.drawable.bhd));
        listCinema.add(new CinemaModel("CGV CT Plaza", "9 Truong Son", "0.8 km",R.drawable.cgv));
        listCinema.add(new CinemaModel("CGV Go Vap", "192 Phan Van Tri", "3 km",R.drawable.cgv));
        listCinema.add(new CinemaModel("Galaxy Nguyen Hong Dao", "201 Nguyen Hong Dao", "7 km",R.drawable.galaxy));
    }
}
