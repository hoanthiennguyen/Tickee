package com.example.tickee.filmschedule;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tickee.R;
import com.example.tickee.model.Cinema;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;

public class CinemaShortDescriptionRecyclerAdapter extends RecyclerView.Adapter<CinemaShortDescriptionRecyclerAdapter.MyViewHolder> {
    Context context;
    List<Cinema> data;
    SparseBooleanArray exState = new SparseBooleanArray();

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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        System.out.println("position" + position);
        holder.cinemaName.setText(data.get(position).getName());
//        holder.cinemaDistance.setText(data.get(position).getDistance());
        holder.cinemaStreet.setText(" - "   + data.get(position).getStreet());
        holder.exSchedule.setInRecyclerView(true);
        holder.exSchedule.setExpanded(exState.get(position));
        holder.exSchedule.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                changeRotate(holder.btnDrop,0f,180f).start();
                exState.put(position,true);
            }

            @Override
            public void onPreClose() {
                changeRotate(holder.btnDrop,180f, 0f).start();
                exState.put(position,false);
            }
        });
        holder.btnDrop.setRotation(exState.get(position)?180f:0f);
        holder.btnDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.exSchedule.toggle();
            }
        });
    }
    private ObjectAnimator changeRotate(RelativeLayout button, float to, float from){
        ObjectAnimator animator = ObjectAnimator.ofFloat(button,"rotation",from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView cinemaName;
        private TextView cinemaStreet;
        private TextView cinemaDistance;
        private TextView movieName;
        private TextView movieDes;
        private RelativeLayout btnDrop;
        private ExpandableLinearLayout exSchedule;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cinemaName =  itemView.findViewById(R.id.cinema_des_name);
            cinemaStreet =  itemView.findViewById(R.id.cinema_street);
            movieName = itemView.findViewById(R.id.movie_name);
            movieDes = itemView.findViewById(R.id.movie_des);
            btnDrop = itemView.findViewById(R.id.btnDrop);
            exSchedule = itemView.findViewById(R.id.expan_list_movie);

        }
    }
}
