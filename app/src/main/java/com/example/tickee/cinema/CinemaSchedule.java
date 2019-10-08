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
        List<TimeModel> timemodelsMatbiec = new ArrayList<>();
        timemodelsMatbiec.add(new TimeModel("18h ","-   20h","~80k"));
        timemodelsMatbiec.add(new TimeModel("20h " ,"-   22h","~90k"));
        List<TimeModel> timeModelsThienThan = new ArrayList<>();
        timeModelsThienThan.add(new TimeModel("17h","-   18h30","~75k"));
        timeModelsThienThan.add(new TimeModel("19h","-   22h30","~85k"));
        List<TimeModel> timeModelsHungThan = new ArrayList<>();
        timeModelsHungThan.add(new TimeModel("15h","-   17h30","~70k"));
        timeModelsHungThan.add(new TimeModel("18h","-   20h30","~90k"));


        super.onCreate(savedInstanceState);
        listDataHeader = new ArrayList<>();
        listDataHeader.add(new MovieModel("Mắt biếc","120p - 9.0 IMDb",timemodelsMatbiec,R.drawable.matbiecbg));
        listDataHeader.add(new MovieModel("Minion 2","90p - 7.9 IMDb",timeModelsThienThan,R.drawable.minion));
        listDataHeader.add(new MovieModel("Hung thần đại dương","150p - 8.9 IMDb",timeModelsHungThan,R.drawable.hungthan));
    }
}
