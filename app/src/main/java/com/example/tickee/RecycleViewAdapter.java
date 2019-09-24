package com.example.tickee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context context;
    List<CinemaModel> data;

    public RecycleViewAdapter(Context context, List<CinemaModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_cinema,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(data.get(position).getCinemaName());
        holder.tv_location.setText(data.get(position).getCinemaLocation());
        holder.tv_distance.setText(data.get(position).getCinemaDistance());
        holder.img.setImageResource(data.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_location;
        private TextView tv_distance;
        private ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.cinema_name);
            tv_location = (TextView) itemView.findViewById(R.id.cinema_location);
            tv_distance = (TextView) itemView.findViewById(R.id.cinema_distance);
            img = (ImageView) itemView.findViewById(R.id.img_cinema);

        }
    }
}
