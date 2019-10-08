package com.example.tickee.cinema;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.tickee.R;
import com.example.tickee.filmschedule.ExpandableListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaSchedule extends Fragment {
    View view;

    List<MovieModel> listDataHeader;
    RecyclerView scheduleRecyclerView;


    public CinemaSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cinema_schedule, container, false);

        scheduleRecyclerView = view.findViewById(R.id.cinema_schedule_recycler);
        CinemaScheduleAdapter cinemaScheduleAdapter = new CinemaScheduleAdapter(getContext(), listDataHeader);
        scheduleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        scheduleRecyclerView.setAdapter(cinemaScheduleAdapter);

        return view;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listDataHeader = new ArrayList<>();
        listDataHeader.add(new MovieModel("Joker","120p - 7.9 IMDb","~ 00:00","22:00 ","~80k",R.drawable.cgv));
        listDataHeader.add(new MovieModel("Aquaman","120p - 7.9 IMDb","~ 00:00","22:00 ","~80k",R.drawable.cgv));
        listDataHeader.add(new MovieModel("Spider man","120p - 7.9 IMDb","~ 00:00","22:00 ","~80k",R.drawable.cgv));
    }
}
