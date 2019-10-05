package com.example.tickee.filmschedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tickee.R;
import com.example.tickee.model.Cinema;

import java.util.List;

public class CinemaShortDescriptionRecyclerAdapter extends RecyclerView.Adapter<CinemaShortDescriptionRecyclerAdapter.MyViewHolder> {
    Context context;
    List<Cinema> data;

    public CinemaShortDescriptionRecyclerAdapter(Context context, List<Cinema> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.short_description_of_near_cinema,parent,false);
        CinemaShortDescriptionRecyclerAdapter.MyViewHolder vHolder = new CinemaShortDescriptionRecyclerAdapter.MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        System.out.println("position" + position);
        holder.cinemaName.setText(data.get(position).getName());
//        holder.cinemaDistance.setText(data.get(position).getDistance());
        holder.cinemaStreet.setText(" - "   + data.get(position).getStreet());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView cinemaName;
        private TextView cinemaStreet;
        private TextView cinemaDistance;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cinemaName =  itemView.findViewById(R.id.cinema_des_name);
            cinemaStreet =  itemView.findViewById(R.id.cinema_street);


        }
    }
}
