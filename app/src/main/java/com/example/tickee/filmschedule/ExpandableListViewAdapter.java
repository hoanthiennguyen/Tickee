package com.example.tickee.filmschedule;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.example.tickee.R;
public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private String[] distances = {"0.3 km", "0.5 km", "1.2 km","1.5 km","2 km"};
    HashMap<String,Integer> colorsOfCinema = new HashMap<>();

    public ExpandableListViewAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        colorsOfCinema.put("BHD", R.color.green);
        colorsOfCinema.put("CNS", R.color.purple);
        colorsOfCinema.put("Galaxy", R.color.StarColor);
        colorsOfCinema.put("MegaCS", R.color.yellow);

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);
        String[] inputs = childText.split(" ");
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.film_schedule_details, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
        TextView txtEndTime = convertView.findViewById(R.id.txtEndTime);
        TextView txtPrice = convertView.findViewById(R.id.txtPrice);

        txtListChild.setText(inputs[0]);
        txtEndTime.setText("-> " +inputs[1]);
        txtPrice.setText(inputs[2]);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String title = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.film_schedule_list, null);
        }
        int indexOfFirstSpace = title.indexOf(' ');
        String cinemaName = title.substring(0,indexOfFirstSpace);
        String street = title.substring(indexOfFirstSpace);

        TextView txtStreet = convertView
                .findViewById(R.id.txtCinemaStreet);
        TextView txtCinemaName = convertView.findViewById(R.id.txtCinemaName);
        TextView txtDistance = convertView.findViewById(R.id.txtDistance);

        txtCinemaName.setText(cinemaName);
        txtCinemaName.setTextColor(_context.getResources().getColor(colorsOfCinema.get(cinemaName)));

        txtDistance.setText(distances[groupPosition]);
        txtStreet.setTypeface(null, Typeface.BOLD);
        txtCinemaName.setTypeface(null, Typeface.BOLD);
        txtStreet.setText(street);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
