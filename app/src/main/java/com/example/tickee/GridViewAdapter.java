package com.example.tickee;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    Context context;
    List<Integer> chairs;


    public GridViewAdapter(Context context, List<Integer> chairs) {
        this.context = context;
        this.chairs = chairs;
    }

    @Override
    public int getCount() {
        return chairs.size();
    }

    @Override
    public Object getItem(int position) {
        return chairs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView button = new TextView(context);
        button.setLayoutParams(new RelativeLayout.LayoutParams(50,50));
        button.setGravity(Gravity.CENTER);
        switch (chairs.get(position)){
            case 0:
                button.setBackgroundResource(R.drawable.roundbuttonwhite);
                break;
            case 1:
                button.setBackgroundResource(R.drawable.roundbackgroundyellow);
                break;
            case -1:
                button.setText("X");
                button.setBackgroundResource(R.drawable.roundbuttondisable);
                break;
        }
        if(convertView == null)
            return button;
        else
            return convertView;
    }
}
