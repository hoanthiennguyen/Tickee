package com.example.tickee.cinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tickee.R;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context context;
    List<CinemaModel> data;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

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
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View view, int position, boolean isLongClick) {
////                if(isLongClick){
////
////                    Toast.makeText(context, "Long click: " + data.get(position).getCinemaName(), Toast.LENGTH_SHORT).show();
////                }else {
////                    Toast.makeText(context, " " + data.get(position).getCinemaName(), Toast.LENGTH_SHORT).show();
////                }
//                FragmentManager manager
//                Fragment nextFrag = new CinemaSchedule();
//                FragmentTransaction transaction;
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
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

            if(itemClickListener!=null){
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.onClick(view, getAdapterPosition());
                        System.out.println(getAdapterPosition());
                    }
                });
            }
        }


    }
}
