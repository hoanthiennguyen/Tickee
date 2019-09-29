package com.example.tickee.filmschedule;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tickee.CinemaModel;
import com.example.tickee.R;
import com.example.tickee.RecycleViewAdapter;
import com.example.tickee.model.Cinema;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmScheduleFragment extends Fragment {
    View view;
    RecyclerView myRecyclerView;
    List<Cinema> listCinema;
    public FilmScheduleFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_film_schedule, container, false);
         myRecyclerView = view.findViewById(R.id.near_cinema_recycler);
        CinemaShortDescriptionRecyclerAdapter recycleViewAdapter = new CinemaShortDescriptionRecyclerAdapter(getContext(), listCinema);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recycleViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCinema = new ArrayList<>();
        listCinema.add(new Cinema("BHD","0.7 km","Nguyen Trai"));
        listCinema.add(new Cinema("Lotte","1 km","Le Loi"));
        listCinema.add(new Cinema("CGV","1.5 km","Tran Hung Dao"));
        listCinema.add(new Cinema("MegaCS","2 km","Pham Van Dong"));
    }
}
