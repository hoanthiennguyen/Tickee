package com.example.tickee;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemNew extends Fragment {
    int imgView;
    String dates;
    String title;
    String dercp;

    public ItemNew() {
        // Required empty public constructor
    }

    public  ItemNew(int imgView, String dates, String title, String dercp) {
        this.imgView = imgView;
        this.dates = dates;
        this.title = title;
        this.dercp = dercp;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_new, container, false);
        ImageView imageView = view.findViewById(R.id.itemImg);
        TextView itemDate = view.findViewById(R.id.itemDate);
        TextView itemTitle = view.findViewById(R.id.itemTitle);
        TextView itemDercp = view.findViewById(R.id.itemDercp);
        imageView.setImageResource(imgView);
        itemDate.setText(dates);
        itemTitle.setText(title);
        itemDercp.setText(dercp);
        return view;
    }

}
