package com.example.tickee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class HomeAdapter extends FragmentStatePagerAdapter {
    private String listTab[] = {"Đang Chiếu", "Sắp Chiếu", "Ngưng Chiếu"};
    private DCFragment dcFragment;
    private SCFragment scFragment;
    private NCFragment ncFragment;
    public HomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
        dcFragment = new DCFragment();
        scFragment = new SCFragment();
        ncFragment = new NCFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return dcFragment;
        }else if(position == 1) {
            return scFragment;
        }else if(position == 2){
            return ncFragment;
        }else {
            //Do nothing
        }
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
