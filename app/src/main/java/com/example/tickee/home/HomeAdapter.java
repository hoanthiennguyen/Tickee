package com.example.tickee.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class HomeAdapter extends FragmentStatePagerAdapter {
    private String listTab[] = {"Đang Chiếu", "Sắp Chiếu", "Đã Chiếu"};
    private PlayingFragment playingFragment;
    private WillPlayFragment willPlayFragment;
    private PlayedFragment playedFragment;
    public HomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
        playingFragment = new PlayingFragment();
        willPlayFragment = new WillPlayFragment();
        playedFragment = new PlayedFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return playingFragment;
        }else if(position == 1) {
            return willPlayFragment;
        }else if(position == 2){
            return playedFragment;
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
