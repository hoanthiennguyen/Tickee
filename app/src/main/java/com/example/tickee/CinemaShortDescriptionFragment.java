package com.example.tickee;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaShortDescriptionFragment extends Fragment {

    String cinema, street, distance;

    public CinemaShortDescriptionFragment(String cinema, String street, String distance) {
        this.cinema = cinema;
        this.street = street;
        this.distance = distance;
    }

    public CinemaShortDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cinema_short_description, container, false);

        TextView txtCinema = view.findViewById(R.id.txtCinema);
        txtCinema.setText(cinema);
        int color = 0;
        switch (cinema) {
            case "BHD":
                color = getResources().getColor(R.color.BHD);
                break;
            case "Lotte":
                color = getResources().getColor(R.color.Lotte);
                break;
            case "MegaGS":
                color = getResources().getColor(R.color.MegaGS);
                break;
            case "CNS":
                color = getResources().getColor(R.color.CNS);
                break;
        }
        txtCinema.setTextColor(color);
        TextView txtStreet = view.findViewById(R.id.txtStreet);
        txtStreet.setText(" - " + street);
        TextView txtDistance = view.findViewById(R.id.txtDistance);
        txtDistance.setText(distance);

        return view;
    }


}
