package com.example.tickee.cinema;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tickee.R;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListCinemaRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<ListCinemaModel> listCinema;
    List<CinemaModel> cinema;
    Context context;
    SparseBooleanArray expanState = new SparseBooleanArray();

    public ListCinemaRecycleViewAdapter(Context context, List<ListCinemaModel> listCinema) {
        this.listCinema = listCinema;

        for(int i=0; i<listCinema.size();i++){
            expanState.append(i, false);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(listCinema.get(position).isExpan())
            return 1;
        else return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View v;

            LayoutInflater inflater = LayoutInflater.from(context);
             v = inflater.inflate(R.layout.item_list_cinema,parent,false);
            return new MyAdapter(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyAdapter viewHolder = (MyAdapter) holder;
        viewHolder.setIsRecyclable(false);
        viewHolder.list_cinenma_name.setText(listCinema.get(position).getName());
        viewHolder.img.setImageResource(listCinema.get(position).getImg());
        viewHolder.expandableLayout.setInRecyclerView(true);
        viewHolder.expandableLayout.setExpanded(expanState.get(position));
        viewHolder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {


            @Override
            public void onPreOpen() {
                changeRotate(viewHolder.button,0f,180f).start();
                expanState.put(position,true);
            }

            @Override
            public void onPreClose() {
                changeRotate(viewHolder.button,180f,0f).start();
                expanState.put(position,false);

            }


        });
        viewHolder.button.setRotation(expanState.get(position)?180f:0f);
        viewHolder.dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.expandableLayout.toggle();
            }
        });
        viewHolder.item_list_cinema_name.setText(listCinema.get(position).getDetails().get(0).getCinemaName());
        viewHolder.item_list_cinema_location.setText(listCinema.get(position).getDetails().get(0).getCinemaLocation());
        viewHolder.item_list_cinema_distance.setText(listCinema.get(position).getDetails().get(0).getCinemaDistance());

    }

    private ObjectAnimator changeRotate(RelativeLayout button, float to, float from){
        ObjectAnimator animator = ObjectAnimator.ofFloat(button,"rotation",from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

    @Override
    public int getItemCount() {
        return listCinema.size();
    }
}

class MyAdapter extends RecyclerView.ViewHolder{
    public TextView list_cinenma_name;
    public TextView item_list_cinema_name;
    public TextView item_list_cinema_location;
    public TextView item_list_cinema_distance;
    public ImageView img;
    public RelativeLayout button;
    public RelativeLayout dropdown;
    public ExpandableLinearLayout expandableLayout;

    public MyAdapter(@NonNull View itemView) {
        super(itemView);
        list_cinenma_name = (TextView) itemView.findViewById(R.id.list_cinenma_name);
        item_list_cinema_name = (TextView) itemView.findViewById(R.id.item_list_cinema_name);
        item_list_cinema_location = (TextView) itemView.findViewById(R.id.item_list_cinema_location);
        item_list_cinema_distance = (TextView) itemView.findViewById(R.id.item_list_cinema_distance);
        img = (ImageView) itemView.findViewById(R.id.img_list_cinema);
        button = (RelativeLayout)itemView.findViewById(R.id.button);
        dropdown = itemView.findViewById(R.id.btnDropDown);
        expandableLayout = (ExpandableLinearLayout)itemView.findViewById(R.id.expan_list_cinema);
    }
}
