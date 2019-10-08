package com.example.tickee.cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tickee.R;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CinemaScheduleAdapter extends RecyclerView.Adapter<CinemaScheduleAdapter.CinemaScheduleHolder> {
    Context context;
    List<MovieModel> listDataHeader;


    public CinemaScheduleAdapter(Context context, List<MovieModel> listDataHeader) {
        this.context = context;
        this.listDataHeader = listDataHeader;

    }

    @NonNull
    @Override
    public CinemaScheduleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.cinema_schedule_movie,parent,false);
        CinemaScheduleHolder vHolder = new CinemaScheduleHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaScheduleHolder holder, int position) {
        holder.movie_name.setText(listDataHeader.get(position).getMovieName());
        holder.movie_des.setText(listDataHeader.get(position).getMovieDes());
        holder.startTime.setText(listDataHeader.get(position).getTimeModelList().get(0).getStartTime());
        holder.endTime.setText(listDataHeader.get(position).getTimeModelList().get(0).getEndTime());
        holder.price.setText(listDataHeader.get(position).getTimeModelList().get(0).getPrice());
        holder.startTime2.setText(listDataHeader.get(position).getTimeModelList().get(1).getStartTime());
        holder.endTime2.setText(listDataHeader.get(position).getTimeModelList().get(1).getEndTime());
        holder.price2.setText(listDataHeader.get(position).getTimeModelList().get(1).getPrice());
        holder.img.setImageResource(listDataHeader.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return listDataHeader.size();
    }

    public static  class CinemaScheduleHolder extends RecyclerView.ViewHolder{
        private TextView movie_name;
        private TextView movie_des;
        private TextView startTime;
        private TextView startTime2;
        private TextView endTime;
        private TextView endTime2;
        private TextView price;
        private TextView price2;
        private ImageView img;


        public CinemaScheduleHolder(@NonNull View itemView) {
            super(itemView);
            movie_name = itemView.findViewById(R.id.cinema_movie_name);
            movie_des = itemView.findViewById(R.id.cinema_movie_des);
            img = itemView.findViewById(R.id.img_movie_schdule);
            startTime = itemView.findViewById(R.id.cinema_movie_startTime);
            startTime2 = itemView.findViewById(R.id.cinema_movie_startTime2);
            endTime = itemView.findViewById(R.id.cinema_movie_endTime);
            endTime2 = itemView.findViewById(R.id.cinema_movie_endTime2);
            price = itemView.findViewById(R.id.cinema_movie_price);
            price2 = itemView.findViewById(R.id.cinema_movie_price2);
        }
    }
}

