package com.example.tickee;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListCinema extends Fragment {
    View v;
    private List<ListCinemaModel> listCinema;
    private List<CinemaModel> cinema;
    private RecyclerView myRecyclerView;

    public ListCinema() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_cinema, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.list_cinema_recycle);
        myRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(layoutManager);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listCinema = new ArrayList<>();
        listCinema.add(new ListCinemaModel("BHD Cinema",R.drawable.bhd,true));
        listCinema.add(new ListCinemaModel("CGV Cinema",R.drawable.cgv,true));
        listCinema.add(new ListCinemaModel("Galaxy Cinema",R.drawable.galaxy,true));
        listCinema.add(new ListCinemaModel("CNS Cinema",R.drawable.cns,true));

        cinema = new ArrayList<>();
        for(int m = 0; m<listCinema.size();m++){
            if(listCinema.get(m).getName() == "BHD Cinema"){
                cinema.add(new CinemaModel("BHD Thao Dien", "304 Quang Trung", "6 km"));
                cinema.add(new CinemaModel("BHD Quang Trung", "231 Quang Trung", "5.6 km"));
                cinema.add(new CinemaModel("BHD 3 Thang 2", "9 Truong Son", "0.8 km"));
            }
        }
    }
}
