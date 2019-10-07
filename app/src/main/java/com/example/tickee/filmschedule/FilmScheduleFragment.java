package com.example.tickee.filmschedule;


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
import com.example.tickee.model.Cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmScheduleFragment extends Fragment {
    View view;
    RecyclerView myRecyclerView;
    ExpandableListViewAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    List<Cinema> listCinema;
    public FilmScheduleFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_film_schedule, container, false);
        expListView =  view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListViewAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return view;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("CNS Quang Trung");
        listDataHeader.add("Galaxy Gò Vấp");
        listDataHeader.add("BHD Phan Văn Trị");
        listDataHeader.add("CNS Lê Lợi");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("7:30 ~ 80k");
        top250.add("9:00 ~ 70k");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("18:00 ~ 60k");
        nowShowing.add("20:00 ~ 70k");
        nowShowing.add("22:00 ~ 60k");


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("16:30 ~ 55k");
        comingSoon.add("18:00 ~ 65k");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), nowShowing);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        listCinema = new ArrayList<>();
//        listCinema.add(new Cinema("BHD","0.7 km","Nguyen Trai"));
//        listCinema.add(new Cinema("Lotte","1 km","Le Loi"));
//        listCinema.add(new Cinema("CGV","1.5 km","Tran Hung Dao"));
//        listCinema.add(new Cinema("MegaCS","2 km","Pham Van Dong"));
    }
}
